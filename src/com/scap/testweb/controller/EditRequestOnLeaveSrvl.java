package com.scap.testweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.EditRequestService;
import com.scap.testweb.service.RequestService;
import com.scap.testweb.service.SendEmailService;

/**
 * Servlet implementation class EditRequestOnLeaveSrvl
 */
@WebServlet("/EditRequestOnLeaveSrvl")
public class EditRequestOnLeaveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRequestOnLeaveSrvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    
	    HttpSession session = request.getSession();
		String userLogin = session.getAttribute("userLogin").toString();
		
		RequestService requestService = new RequestService();
		EditRequestService editRequestService = new EditRequestService();
	    
	    String approve = request.getParameter("sendApprove");
	    String notAllowed = request.getParameter("sendNotAllowed");
	    String emailUser = request.getParameter("email");
	    
	    String code = request.getParameter("sendCode");
	    String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String typeLeave = request.getParameter("comboTypeLeave");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateDiff = request.getParameter("txtDateDiff");
		String note = request.getParameter("txtAreaNote");
		
		String fullName = fName+" "+lName;
		
//		String userPosition = requestService.findPosition(userLogin);

		String mailBoss = requestService.findEmailBoss();
		
		SendEmailService seService = new SendEmailService();
		
		if(userLogin.equals(mailBoss)){
			if(approve != null){
				boolean rerult = editRequestService.setDataApprove(code, approve);
				if(rerult){
				try{
				seService.sendApprove(emailUser,"คำร้องขอของคุณ  \"ได้รับการอนุมัติ \""); // send new password to Email
				response.getWriter().write("true");
				}catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("Send Email fail.");
				}
				}else{
					response.getWriter().write("Failed to save data.");
				}
			}
			else{
				boolean rerult = editRequestService.setDataApprove(code, notAllowed);
				if(rerult){
				try{
					seService.sendApprove(emailUser,"คำร้องขอของคุณ \"ไม่ได้รับการอนุมัติ\""); // send new password to Email
					response.getWriter().write("true");
					}catch (Exception e) {
						e.printStackTrace();
						response.getWriter().write("Send Email fail.");
					}
				}else{
					response.getWriter().write("Failed to save data.");
				}
			}
		}
		else{
			boolean rerult = requestService.setEditDataRequest(code, typeLeave, startDate, endDate,dateDiff,note);
			if(rerult){
			try{
				seService.sendRequest("purasri_p2p@hotmail.com",typeLeave,fullName); // send new password to Email
				response.getWriter().write("true");
			}catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("Send Email fail.");
				}
			}else{
				response.getWriter().write("Failed to save data.");
			}
		}
	}
}

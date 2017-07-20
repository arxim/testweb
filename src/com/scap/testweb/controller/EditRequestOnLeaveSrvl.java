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
	    String fNmae = request.getParameter("fristName");
		String lNmae = request.getParameter("lastName");
		String typeLeave = request.getParameter("comboTypeLeave");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateDiff = request.getParameter("txtDateDiff");
		String note = request.getParameter("txtAreaNote");
		
		String fullName = fNmae+" "+lNmae;
		
//		String userPosition = requestService.findPosition(userLogin);

		String mailBoss = requestService.findEmailBoss();
		
		SendEmailService seService = new SendEmailService();
		
		if(userLogin.equals(mailBoss)){
			if(approve != null){
				try{
				String sendEmail=seService.sendApprove(emailUser,"คำร้องขอถูกอนุมัติ"); // send new password to Email
				if(sendEmail=="PASS"){
					boolean resultApprove = editRequestService.setDataApprove(code, approve);
					if(resultApprove)
						response.getWriter().write("true");
					else
						response.getWriter().write("false");
				 }
				 else{
					 response.getWriter().write("false");
				 } 
				}catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("false");
				}
			}
			else{
				try{
					String sendEmail=seService.sendApprove(emailUser,"คำร้องขอไม่ถูกอนุมัติ"); // send new password to Email
					if(sendEmail=="PASS"){
						boolean resultnotAllowed = editRequestService.setDataApprove(code, notAllowed);
						if(resultnotAllowed)
							response.getWriter().write("true");
						else
							response.getWriter().write("false");
					 }
					 else{
						 response.getWriter().write("false");
					 } 
					}catch (Exception e) {
						e.printStackTrace();
						response.getWriter().write("false");
					}
			}
		}
		else{
			try{
				String sendEmail=seService.sendRequest("purasri_p2p@hotmail.com",typeLeave,fullName); // send new password to Email
				if(sendEmail=="PASS"){
					requestService.setEditDataRequest(code, typeLeave, startDate, endDate,dateDiff,note);
					System.out.println("ประเภทการลา: "+typeLeave+"\nเวลาเริ่ม: "+startDate+"\nเวลาสิ้นสุด: "+endDate+"\nจำนวนวัน: "+dateDiff+"\nหมายเหตุ: "+note);
				 }
				 else{
					 System.out.println("error");
				 } 
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("error");
				}
		}
	}
}

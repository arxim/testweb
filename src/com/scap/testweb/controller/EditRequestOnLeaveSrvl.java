package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.EditRequestService;
import com.scap.testweb.service.RequestService;

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
	    
	    String code = request.getParameter("sendCode");
		String typeLeave = request.getParameter("comboTypeLeave");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateDiff = request.getParameter("txtDateDiff");
		String note = request.getParameter("txtAreaNote");
		
//		String userPosition = requestService.findPosition(userLogin);
		String boss = "boss@gmail.com";
		
		if(userLogin.equals(boss)){
			if(approve != null){
				boolean resultApprove = editRequestService.setDataApprove(code, approve);
				if(resultApprove)
					response.getWriter().write("true");
				else
					response.getWriter().write("false");
			}
			else{
				boolean resultnotAllowed = editRequestService.setDataApprove(code, notAllowed);
				if(resultnotAllowed)
					response.getWriter().write("true");
				else
					response.getWriter().write("false");
			}
		}
		else{
			requestService.setEditDataRequest(code, typeLeave, startDate, endDate,dateDiff,note);
			System.out.println("ประเภทการลา: "+typeLeave+"\nเวลาเริ่ม: "+startDate+"\nเวลาสิ้นสุด: "+endDate+"\nจำนวนวัน: "+dateDiff+"\nหมายเหตุ: "+note);
		}
	}
}

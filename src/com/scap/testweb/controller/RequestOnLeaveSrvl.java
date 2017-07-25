package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.RequestService;
import com.scap.testweb.service.SendEmailService;

/**
 * Servlet implementation class RequestOnLeaveSrvl
 */
@WebServlet("/RequestOnLeaveSrvl")
public class RequestOnLeaveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestOnLeaveSrvl() {
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
	    
	    String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String typeLeave = request.getParameter("comboTypeLeave");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateDiff = request.getParameter("txtDateDiff");
		String note = request.getParameter("txtAreaNote");
		
		String fullName = fName+" "+lName;
		String mailBoss = requestService.findEmailBoss();
		
		String employee_id = requestService.findID(userLogin);
		String boss_id = requestService.findBossID();
		
		SendEmailService seService = new SendEmailService();
		boolean rerult = requestService.setDataRequest(employee_id, boss_id, typeLeave, startDate, endDate,dateDiff,note);
		if(rerult){
			try {
				seService.sendRequest(mailBoss, typeLeave, fullName); // send new password to Email
				response.getWriter().write("true");
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("Send Email fail.");
			}
		}else{
			response.getWriter().write("Failed to save data.");
		}
	}
}

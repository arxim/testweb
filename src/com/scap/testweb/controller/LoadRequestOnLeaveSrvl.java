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

/**
 * Servlet implementation class RequestSrvl
 */
@WebServlet("/LoadRequestOnLeaveSrvl")
public class LoadRequestOnLeaveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadRequestOnLeaveSrvl() {
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
		String fName = requestService.findFirstName(userLogin);
		String lName = requestService.findLastName(userLogin);
		String comboDepartment = requestService.findDepartment(userLogin);
		String comboPosition = requestService.findPosition(userLogin);
		String comboBoss = requestService.findNameBoss();
		String mailBoss = requestService.findEmailBoss();
		String comboTypeLeave = "";
		String startDate = "";
		String endDate = "";
		String txtDateDiff = "";
		String txtAreaNote = "";
		
		String leaveCode = "";
		request.getSession().setAttribute("leaveCode", leaveCode);
		
		request.getSession().setAttribute("fName", fName);
		request.getSession().setAttribute("lName", lName);
		request.getSession().setAttribute("comboDepartment", comboDepartment);
		request.getSession().setAttribute("comboPosition", comboPosition);
		request.getSession().setAttribute("txtemail", userLogin);
		request.getSession().setAttribute("comboBoss", comboBoss);
		request.getSession().setAttribute("mailBoss", mailBoss);
		request.getSession().setAttribute("comboTypeLeave", comboTypeLeave);
		request.getSession().setAttribute("startDate", startDate);
		request.getSession().setAttribute("endDate", endDate);
		request.getSession().setAttribute("txtDateDiff", txtDateDiff);
		request.getSession().setAttribute("txtAreaNote", txtAreaNote);
		
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/requestOnLeave/requestOnLeave.jsp"); 
//		rd.forward(request, response);
		String urlRedirect = request.getContextPath() + "/pages/requestOnLeave/requestOnLeave.jsp";
		response.sendRedirect(urlRedirect);
	}

}

package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scap.testweb.service.ApproveService;

/**
 * Servlet implementation class ApproveButtonSrvl
 */
@WebServlet("/ApproveButtonSrvl")
public class ApproveButtonSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveButtonSrvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String statusSrvl = request.getParameter("status");
		String codeSrvl = request.getParameter("code");
		String process = request.getParameter("process");
		
		if (process != null && !process.isEmpty()) {
			response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    
		    ApproveService dt = new ApproveService();
		    String update = dt.approveData(statusSrvl, codeSrvl);
		    if(update == "อนุมัติ"){
		    	String result = "อนุมัติ";
			    response.getWriter().write(result);
		    }
		    else if(update == "รออนุมัติ"){
		    	String result =  "รออนุมัติ";
		    	response.getWriter().write(result);
		    }
		    else{
		    	response.getWriter().write("null");
		    }
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/approveOnLeave/approveOnLeave.jsp"); 
			rd.forward(request, response);	
		}
	}
}

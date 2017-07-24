package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scap.testweb.service.ApproveService;
import com.scap.testweb.service.SendEmailService;

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
		String rowIDSrvl = request.getParameter("rowID");
		
		if (rowIDSrvl != null && !rowIDSrvl.isEmpty()) {
			response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    
		    ApproveService dt = new ApproveService();
		    String result = dt.approveData(statusSrvl, rowIDSrvl);
		    
		    SendEmailService seService = new SendEmailService();
		    
		    if(result.equals("อนุมัติ")){
				try{
				String emailUser = dt.findEmployeeID(rowIDSrvl);
				seService.sendApprove(emailUser,"คำร้องขอของคุณ  \"ได้รับการอนุมัติ \""); // send new password to Email
				}catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("false");
				}
		    }
		    else{
		    	try{
		    	String emailUser = dt.findEmployeeID(rowIDSrvl);
				seService.sendApprove(emailUser,"คำร้องขอของคุณ \"ไม่ได้รับการอนุมัติ\""); // send new password to Email
				}catch (Exception e) {
					e.printStackTrace();
					response.getWriter().write("false");
				}
		    }
		}else {
//			RequestDispatcher rd = request.getRequestDispatcher("pages/approveOnLeave/approveOnLeave.jsp"); 
//			rd.forward(request, response);
			response.setContentType("text/html");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
			String urlRedirect = request.getContextPath() + "/pages/approveOnLeave/approveOnLeave.jsp";
			response.sendRedirect(urlRedirect);
		}
		
	}
}

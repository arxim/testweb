package com.scap.testweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.scap.testweb.model.User;
import com.scap.testweb.service.ApproveService;

/**
 * Servlet implementation class ApproveUserSrvl
 */
@WebServlet("/ApproveUserSrvl")
public class ApproveUserSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveUserSrvl() {
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
		String userLoginSrvl = request.getParameter("userLogin");
		String process = request.getParameter("process");
		
		if (process != null && !process.isEmpty()) {
			response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    
		    ApproveService dt = new ApproveService();
		    String userID = dt.personal(userLoginSrvl);
		    List<User> userLeave = dt.leave(userID);
	
		    Gson gson = new Gson();
		    PrintWriter out = response.getWriter();
		    String json = gson.toJson(userLeave);
			out.print("{ \"data\":" + json + "}");
			
		}
		else {
//			RequestDispatcher rd = request.getRequestDispatcher("pages/approveOnLeave/approveOnLeave.jsp"); 
//			rd.forward(request, response);
			response.setContentType("text/html");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
			String urlRedirect = request.getContextPath() + "/pages/approveOnLeave/approveOnLeave.jsp";
			response.sendRedirect(urlRedirect);
		}
	}
}
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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.scap.testweb.model.User;
import com.scap.testweb.service.ApproveService;

/**
 * Servlet implementation class ApproveSrvl
 */
@WebServlet("/ApproveSrvl")
public class ApproveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveSrvl() {
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
		String process = request.getParameter("process");
		
		if (process != null && !process.isEmpty()) {
			response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
		    
		    ApproveService dt = new ApproveService();
		    List<User> users = dt.showData(statusSrvl);
		    
		    Gson gson = new Gson();
		    PrintWriter out = response.getWriter();
		    String json = gson.toJson(users);
			out.print("{ \"data\":" + json + "}");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/approveOnLeave/approveOnLeave.jsp"); 
			rd.forward(request, response);	
		}
	}
}

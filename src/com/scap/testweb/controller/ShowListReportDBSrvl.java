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
import com.scap.testweb.service.ShowListReportService;

/**
 * Servlet implementation class ShowListReportDBSrvl
 */
@WebServlet("/ShowListReportDBSrvl")
public class ShowListReportDBSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowListReportDBSrvl() {
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
		String name = request.getParameter("nameEmployee");
		String surname = request.getParameter("surnameEmployee");
		String department = request.getParameter("departmentEmployee");
		String position = request.getParameter("positionEmployee");
		String minday = request.getParameter("minDay");
		String maxday = request.getParameter("maxDay");
		String leavetype = request.getParameter("leaveType");
		String statustype = request.getParameter("statusType");
		String process = request.getParameter("process");
		
		if (process != null && !process.isEmpty()) {
			ShowListReportService slrService=new ShowListReportService();
			response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
			response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
			List<User> users = slrService.getListOnLeave(name,surname,department,position,minday,maxday,leavetype,statustype);
			Gson gson = new Gson();
		    PrintWriter out = response.getWriter();
		    String json = gson.toJson(users);
			out.print("{ \"data\":" + json + "}");
		}
		else{
//			RequestDispatcher rd = request.getRequestDispatcher("pages/reportOnLeave/reportOnLeave.jsp"); 
//			rd.forward(request, response);	
			response.setContentType("text/html");  // Set content type of the response so that jQuery knows what it can expect.
		    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
			String urlRedirect = request.getContextPath() + "/pages/reportOnLeave/reportOnLeave.jsp";
			response.sendRedirect(urlRedirect);
		}
	}
}

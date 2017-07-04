package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.ChangePwdService;

/**
 * Servlet implementation class LoginSrvl
 */
@WebServlet("/LoginSrvl")
public class ChangePwdSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdSrvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    
		String emailSrvl = request.getParameter("txtEmailLogin");
		String pwdSrvl = request.getParameter("txtConfirmPwd");
		String newpwdSrvl = request.getParameter("txtNewPwd");
		String renewpwdSrvl = request.getParameter("txtReNewPwd");
		
		String result = null;
		try {
			ChangePwdService changePass = new ChangePwdService();
			boolean ConfPwd = changePass.ConfirmPwd(emailSrvl,pwdSrvl);
			if (ConfPwd) {
				result = "true";
			}
			else {
				result = "false";
			}
		}catch(Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		// Response
	    response.getWriter().write(result);
	}
	
}

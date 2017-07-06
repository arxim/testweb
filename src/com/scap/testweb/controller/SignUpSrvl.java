package com.scap.testweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.scap.testweb.service.SignUpService;

/**
 * Servlet implementation class SignUpSrvl
 */
@WebServlet("/SignUpSrvl")
public class SignUpSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpSrvl() {
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
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    
		String emailSrvl = request.getParameter("emailSignUp");
		String pwdSrvl = request.getParameter("pwdSignUp");

		String result = null;
		try {
			SignUpService signupserv = new SignUpService();
			
			boolean chkEmail = signupserv.checkEmail(emailSrvl);
			boolean chkPwd = signupserv.checkPassword(pwdSrvl); 
			String chktest = signupserv.chktest(chkEmail,chkPwd,emailSrvl,pwdSrvl);
			
			if (chktest == "Success") {
				result = "Success";
			}
			else if(chktest == "Failed"){
				result = "Failed";
			}
			else if(chktest == "ChangeEmail"){
				result = "ChangeEmail";
			}
			else if(chktest == "ChangePassword"){
				result = "ChangePassword";
			}
			else{
				result = "ChangeEmailandPassword";
			}
		}catch(Exception e) {
			e.printStackTrace();
			result = "Failed";
		}	    
	    // Response
	    response.getWriter().write(result);
	}
	
}

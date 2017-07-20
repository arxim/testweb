package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.AlertService;
import com.scap.testweb.service.LoginService;

/**
 * Servlet implementation class LoginSrvl
 */
@WebServlet("/LoginSrvl")
public class LoginSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrvl() {
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
		String pwdSrvl = request.getParameter("txtPwdLogin");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/approveOnLeave/approveOnLeave.jsp");
		try {
			LoginService loginServ = new LoginService();
			HttpSession session = request.getSession();
			if (loginServ.chkLogin(emailSrvl, pwdSrvl)) {
				
				session.setAttribute("userLogin", emailSrvl);
				
				AlertService pwdDate = new AlertService();
				if(pwdDate.compareDate(emailSrvl)){
					rd.forward(request, response);
					//response.sendRedirect("WEB-INF/pages/mainMenu/mainMenu.jsp");
				}
				else{
					session.setAttribute("msgTimeout", "You have been using your password for more than 90 days. Please change your password.");
					//response.sendRedirect("WEB-INF/pages/mainMenu/mainMenu.jsp");
					rd.forward(request, response);
				}
			}else {
				session.setAttribute("msgLoginError", "E-mail or password is incorrect");
				response.sendRedirect("/testweb/index.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

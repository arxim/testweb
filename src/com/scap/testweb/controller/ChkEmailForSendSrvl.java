package com.scap.testweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scap.testweb.dao.ForgotPwdDao;
import com.scap.testweb.service.ForgotPwdService;
import com.scap.testweb.service.SendEmailService;
import com.scap.testweb.service.SignUpService;

/**
 * Servlet implementation class chkEmailForSend
 */
@WebServlet("/ChkEmailForSendSrvl")
public class ChkEmailForSendSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChkEmailForSendSrvl() {
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
		String emailForgotSrvl = request.getParameter("emailSend");
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    PrintWriter print = response.getWriter();
	    ForgotPwdService email = new ForgotPwdService();
	    ForgotPwdDao pwdDao = new ForgotPwdDao();
	    SignUpService suService = new SignUpService();
	    SendEmailService seService = new SendEmailService();
		try {
			if(email.chkEmailForgot(emailForgotSrvl)){ //if found Email for genpassword
				 String newPwd=email.genPassword(6,8);
				 String md5=suService.cryptWithMD5(newPwd); //md5 new password
				 if(!newPwd.isEmpty()){ //if genpassword is not " "
					 pwdDao.updateGenPassword(emailForgotSrvl,md5); // update data for md5 new genpassword
					 seService.sendEmail(emailForgotSrvl,newPwd); // send new password to Email
					 if(seService.sendEmail(emailForgotSrvl,newPwd)=="PASS"){
						 print.write("Send Email : "+emailForgotSrvl+" Success !!"); // send new password complete
					 }
					 else{
						 print.write("Send Email fail !!");// send new password fail (Problem in internet)
					 } 
				 }
				 else{
					 
				 }
				 
			}else{
				 print.write("This email is not in DB");//Email not in DB
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	    print.close();
	}

}

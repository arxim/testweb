package com.scap.testweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.dao.RequestDao;
import com.scap.testweb.service.RequestService;
import com.scap.testweb.service.SendEmailService;

/**
 * Servlet implementation class RequestOnLeaveSrvl
 */
@WebServlet("/RequestOnLeaveSrvl")
public class RequestOnLeaveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestOnLeaveSrvl() {
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
	    
	    String fNmae = request.getParameter("fristName");
		String lNmae = request.getParameter("lastName");
		String typeLeave = request.getParameter("comboTypeLeave");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateDiff = request.getParameter("txtDateDiff");
		String note = request.getParameter("txtAreaNote");
		
		String fullName = fNmae+" "+lNmae;
		String mailBoss = requestService.findEmailBoss();
		
		String employee_id = requestService.findID(userLogin);
		String boss_id = requestService.findBossID();
		
		SendEmailService seService = new SendEmailService();
		PrintWriter print = response.getWriter();
		try{
		String sendEmail=seService.sendRequest("purasri_p2p@hotmail.com",typeLeave,fullName); // send new password to Email
		if(sendEmail=="PASS"){
			requestService.setDataRequest(employee_id, boss_id, typeLeave, startDate, endDate,dateDiff,note);
			//System.out.println("ID : "+employee_id+ "\nชื่อ: "+fNmae+"\nนามสกุล: "+lNmae+"\nแผนก: "+ epyDepartment+"\nตำแหน่ง: "+epyPosition+"\nอีเมลล์: "+email+"\nชื่อหัวหน้า: "+nameBoss+"\nประเภทการลา: "+typeLeave+"\nเวลาเริ่ม: "+startDate+"\nเวลาสิ้นสุด: "+endDate+"\nจำนวนวัน: "+dateDiff+"\nหมายเหตุ: "+note);
		 }
		 else{
			 print.write("Send Email Fail !!");// send new password fail (Problem in internet)
		 } 
		}catch (Exception e) {
			e.printStackTrace();
			print.write("Send Email fail !!");// send new password fail (Problem in internet)
		}
		
		
	}
}

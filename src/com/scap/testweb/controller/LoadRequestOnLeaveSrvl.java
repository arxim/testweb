package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.RequestService;

/**
 * Servlet implementation class RequestSrvl
 */
@WebServlet("/LoadRequestOnLeaveSrvl")
public class LoadRequestOnLeaveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadRequestOnLeaveSrvl() {
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
		HttpSession session = request.getSession();
		String userLogin = session.getAttribute("userLogin").toString();
		
		RequestService requestService = new RequestService();
		String fName = requestService.findFirstName(userLogin);
		String lName = requestService.findLastName(userLogin);
		String comboDepartment = requestService.findDepartment(userLogin);
		String comboPosition = requestService.findPosition(userLogin);
		String comboBoss = requestService.findNameBoss(userLogin);
		String comboTypeLeave = "ลาพักร้อน";
		String startDate = "2017/07/07";
		String endDate = "2017/07/14";
		String txtDateDiff = "8";
		String txtAreaNote = "อากาศมันร้อน ขอนอนอยู่บ้านค่ะ";
		
		request.setAttribute("fName",fName);
		request.setAttribute("lName", lName);
		request.setAttribute("comboDepartment", comboDepartment);
		request.setAttribute("comboPosition", comboPosition);
		request.setAttribute("txtemail", userLogin);
		request.setAttribute("comboBoss", comboBoss);
		request.setAttribute("comboTypeLeave", comboTypeLeave);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("txtDateDiff", txtDateDiff);
		request.setAttribute("txtAreaNote", txtAreaNote);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/requestOnLeave/requestOnLeave.jsp"); 
		rd.forward(request, response);
	}

}

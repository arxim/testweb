package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.service.EditRequestService;
import com.scap.testweb.service.RequestService;

/**
 * Servlet implementation class EditRequestSrvl
 */
@WebServlet("/LoadEditRequestOnLeaveSrvl")
public class LoadEditRequestOnLeaveSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadEditRequestOnLeaveSrvl() {
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
		
		EditRequestService editRequestService = new EditRequestService();
		RequestService requestService = new RequestService();
		
		String leaveCode = request.getParameter("code");
//		String leaveCode = "2989763799";
		
		String status = editRequestService.findStatus(leaveCode);
		String fName = editRequestService.findFristNameUser(leaveCode);
		String lName = editRequestService.findLastNameUser(leaveCode);
		String comboDepartment = editRequestService.findDepartmentUser(leaveCode);
		String comboPosition = editRequestService.findPositionUser(leaveCode);
		String txtemail = editRequestService.findEmailUser(leaveCode);
		String comboBoss = editRequestService.findNameBossUser(leaveCode);
		String comboTypeLeave = editRequestService.findLeaveType(leaveCode);
		String startDate = editRequestService.findStartDate(leaveCode);
		String endDate = editRequestService.findEndDate(leaveCode);
		String txtDateDiff = editRequestService.findDateDiff(leaveCode);
		String txtAreaNote = editRequestService.findNote(leaveCode);
		String mailBoss = requestService.findEmailBoss();
		
		request.setAttribute("leaveCode", leaveCode);
		request.setAttribute("status", status);
		request.setAttribute("fName",fName);
		request.setAttribute("lName", lName);
		request.setAttribute("comboDepartment", comboDepartment);
		request.setAttribute("comboPosition", comboPosition);
		request.setAttribute("txtemail", txtemail);
		request.setAttribute("comboBoss", comboBoss);
		request.setAttribute("comboTypeLeave", comboTypeLeave);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("txtDateDiff", txtDateDiff);
		request.setAttribute("txtAreaNote", txtAreaNote);
		request.setAttribute("mailBoss", mailBoss);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/requestOnLeave/requestOnLeave.jsp"); 
		rd.forward(request, response);
	}

}

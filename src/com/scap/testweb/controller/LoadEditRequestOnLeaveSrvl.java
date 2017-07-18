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
		
		String leaveCode = "7517107799";
		
		EditRequestService requestService = new EditRequestService();
		String status = requestService.findStatus(leaveCode);
		String fName = requestService.findFristNameUser(leaveCode);
		String lName = requestService.findLastNameUser(leaveCode);
		String comboDepartment = requestService.findDepartmentUser(leaveCode);
		String comboPosition = requestService.findPositionUser(leaveCode);
		String txtemail = requestService.findEmailUser(leaveCode);
		String comboBoss = requestService.findNameBossUser(leaveCode);
		String comboTypeLeave = requestService.findLeaveType(leaveCode);
		String startDate = requestService.findStartDate(leaveCode);
		String endDate = requestService.findEndDate(leaveCode);
		String txtDateDiff = requestService.findDateDiff(leaveCode);
		String txtAreaNote = requestService.findNote(leaveCode);
		
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
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/requestOnLeave/requestOnLeave.jsp"); 
		rd.forward(request, response);
	}

}

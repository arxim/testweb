package com.scap.testweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scap.testweb.dao.RequestDao;
import com.scap.testweb.service.RequestService;

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
	    
	    String approve = request.getParameter("sendApprove");
	    String notAllowed = request.getParameter("sendNotAllowed");
	    String fNmae = request.getParameter("fristName");
		String lNmae = request.getParameter("lastName");
		String epyDepartment = request.getParameter("comboDepartment");
		String epyPosition = request.getParameter("comboPosition");
		String email = request.getParameter("txtemail");
		String nameBoss = request.getParameter("comboBoss");
		String typeLeave = request.getParameter("comboTypeLeave");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String dateDiff = request.getParameter("txtDateDiff");
		String note = request.getParameter("txtAreaNote");
		
		String userPosition = requestService.findPosition(userLogin);
		String employee_id = requestService.findID(userLogin);
		String boss_id = requestService.findBossID(userLogin);
		
		if(userPosition == "หัวหน้าพนักงาน"){
			if(approve != null){
				boolean resultApprove = requestService.setDataApprove(approve);
				//System.out.println("คำร้องขอ : อนุมัติ");
				if(resultApprove)
					response.getWriter().write("true");
				else
					response.getWriter().write("false");
			}
				
			else{
				boolean resultnotAllowed = requestService.setDataApprove(notAllowed);
				//System.out.println("คำร้องขอ : ไม่อนุมัติ");
				if(resultnotAllowed)
					response.getWriter().write("true");
				else
					response.getWriter().write("false");
			}
			
		}
		else{
			requestService.setDataRequest(employee_id, boss_id, typeLeave, startDate, endDate,dateDiff,note);
			System.out.println("ID : "+employee_id+ "\nชื่อ: "+fNmae+"\nนามสกุล: "+lNmae+"\nแผนก: "+ epyDepartment+"\nตำแหน่ง: "+epyPosition+"\nอีเมลล์: "+email+"\nชื่อหัวหน้า: "+nameBoss+"\nประเภทการลา: "+typeLeave+"\nเวลาเริ่ม: "+startDate+"\nเวลาสิ้นสุด: "+endDate+"\nจำนวนวัน: "+dateDiff+"\nหมายเหตุ: "+note);
		}
	}
}

package com.scap.testweb.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scap.testweb.service.JasperBuilderService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class RenderReportSrvl
 */
@WebServlet("/RenderReportSrvl")
public class RenderReportSrvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RenderReportSrvl() {
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
		String id = request.getParameter("user");
		String code = request.getParameter("code");
//		System.out.println("Id="+id);
//		System.out.println("Code="+code);
		Map<String, Object> params = new HashMap<>();
		JasperBuilderService voJasperBuilder = new JasperBuilderService();
		params.put("id",id);
		params.put("code",code);
		try {
		    InputStream jasperStream = request.getSession().getServletContext().getResourceAsStream("/WEB-INF/report/reportOnLeave.jasper");
		    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		    voJasperBuilder.jasperBuilder(jasperStream,jasperReport, response,params, "application/pdf","reportOnLeave");
		}catch (JRException | SQLException e) {
		    e.printStackTrace();
		}
	}
}

package com.scap.testweb.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.pdf.PdfWriter;
import com.scap.testweb.utils.DbConnector;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public class JasperBuilderService {
	public void jasperBuilder(InputStream jasperStream, JasperReport jasperReport, HttpServletResponse response,
			Map<String, Object> params, String contentType, String vaFilesName)
			throws JRException, IOException, SQLException {
			Connection conn = null;
			try {
				// get connecttion
				DbConnector con = new DbConnector();
				conn = con.getConnection();
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
	
				response.setContentType(contentType);
				response.setHeader("Content-disposition", "inline; filename=" + vaFilesName + ".pdf");
				OutputStream out = response.getOutputStream();
	
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
				SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
				exporter.setConfiguration(configuration);
				exporter.exportReport();
	
				// close Stream
				jasperStream.close();
				out.close();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn.close();
			}
	}
}

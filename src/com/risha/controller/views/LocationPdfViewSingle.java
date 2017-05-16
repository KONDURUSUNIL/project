package com.risha.controller.views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.risha.model.Location;

public class LocationPdfViewSingle extends AbstractPdfView {

	@SuppressWarnings("unused")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter pdf, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		
		 	String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date()).toString();
		    String headerString = "Report Date: "+date;
		
		
		
			Location loc = (Location)map.get("idObj");
			Integer locId = loc.getLocId();
			String locName = loc.getLocName();
			String locType = loc.getLocType();
			String locSup = loc.getLocSup();
			String locAdv = loc.getLocAdv();
			String locSta = loc.getLocSta();
			String locCou = loc.getLocCou();
			Double locPin = loc.getLocPin();
			
			
			Paragraph p = new Paragraph();
			p.add("DATE:"+date+"\n");
			p.add("WELCOME TO Location Pdf"+"\n");
			p.add("HELLO"+"\n");
			
			p.add("Created With ID:"+locId+"\n");
			p.add("created with Name:"+locName+"\n");
			p.add("Location Type:"+locType+"\n");
			p.add("Supervisor Name:"+locSup+"\n");
			p.add("Advisior Name:"+locAdv+"\n");
			p.add("state:"+locSta+"\n");
			p.add("Country:"+locCou+"\n");
			p.add("Pin Code:"+locPin+"\n");
			
			
			
			p.add("Thanks You"+"\n");
			p.add("Admin"+"\n");
						
			p.add("Sathya Technologies"+"\n");
			
		
			document.add(p);
			

	}

}

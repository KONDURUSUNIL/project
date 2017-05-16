package com.risha.controller.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.risha.model.Customer;

public class CustomerPdfViewSingle extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter pdf, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		document.add(new Paragraph("Customer Details:"));
		
			Customer cust = (Customer)map.get("custObj");
			Integer id = cust.getCustId();
			String name = cust.getCustName();
			String type = cust.getCustType();
			String email = cust.getCustEmail();
			String addr = cust.getCustAddr();
			Double mob = cust.getCustMob();
			

			Paragraph p = new Paragraph();
			p.add("ID"+id+"\n");
			p.add("Name"+name+"\n");
			p.add("Type"+type+"\n");
			p.add("Email"+email+"\n");
			p.add("ADDR"+addr+"\n");
			p.add("Mob"+mob+"\n");
			
			document.add(p);

	}

}

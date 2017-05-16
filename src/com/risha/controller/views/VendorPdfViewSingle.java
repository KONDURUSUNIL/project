package com.risha.controller.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.risha.model.Vendor;

public class VendorPdfViewSingle extends AbstractPdfView {

	
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter pdf, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		document.add(new Paragraph("Vendor"));
		
		Vendor ven = (Vendor) map.get("venById");
		
		Paragraph p =new Paragraph();
		p.add("Vendor Id:"+ven.getId()+"\n");
		p.add("Vendor Name:"+ven.getName()+"\n");
		p.add("Vendor Email:"+ven.getEmail()+"\n");
		p.add("Vendor Loc Name:"+ven.getLoc().getLocName()+"\n");
		p.add("Vendor Loc Type:"+ven.getLoc().getLocType()+"\n");
		p.add("vendor Address:"+ven.getAddr()+"\n");
		p.add("Gendor :"+ven.getGen()+"\n");
		
		document.add(p);
		
	}
}

package com.risha.controller.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.risha.model.Vendor;

public class VendorPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter pdf, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			List<Vendor> ven = (List<Vendor>)map.get("listVenObj");
			
			document.add(new Paragraph("Vendors List"));
			
			Table table =new Table(7);
			table.addCell("Id");
			table.addCell("Name");
			table.addCell("Email");
			table.addCell("Loc Name");
			table.addCell("Loc Type");
			table.addCell("Address");
			table.addCell("Gender");
			
			for (Vendor vendor : ven) {
				table.addCell(""+vendor.getId());
				table.addCell(vendor.getName());
				table.addCell(vendor.getEmail());
				table.addCell(vendor.getLoc().getLocName());
				table.addCell(vendor.getLoc().getLocType());
				table.addCell(vendor.getAddr());
				table.addCell(vendor.getGen());
			}
			
			
			document.add(table);
			
	}

}

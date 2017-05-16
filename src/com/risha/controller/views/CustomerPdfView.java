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
import com.risha.model.Customer;

public class CustomerPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter pdf, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			List<Customer> listcust = (List<Customer>)map.get("listcustObj");
			
			document.add(new Paragraph("Customers"));
			
			Table table = new Table(6);
			table.addCell("ID:");
			table.addCell("Name:");
			table.addCell("Type");
			table.addCell("Email");
			table.addCell("Address");
			table.addCell("Mobile");
			
			
			for (Customer customer : listcust) {
				
				table.addCell(""+customer.getCustId());
				table.addCell(customer.getCustName());
				table.addCell(customer.getCustType());
				table.addCell(customer.getCustEmail());
				table.addCell(customer.getCustAddr());
				table.addCell(""+customer.getCustMob());
				
			}
		
			document.add(table);

	}

}

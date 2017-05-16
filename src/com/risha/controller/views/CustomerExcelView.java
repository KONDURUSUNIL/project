package com.risha.controller.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.risha.model.Customer;

public class CustomerExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			List<Customer> listcust = (List<Customer>)map.get("listcust");
			
			HSSFSheet sheet = book.createSheet();
			
			
			setHeader(sheet);
			
			setBody(sheet,listcust);
			
			
		

	}

	private void setBody(HSSFSheet sheet, List<Customer> listcust) {
		int rownum=1;
		for (Customer customer : listcust) {
			
			HSSFRow row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(customer.getCustId());
			row.createCell(1).setCellValue(customer.getCustName());
			row.createCell(2).setCellValue(customer.getCustType());
			row.createCell(3).setCellValue(customer.getCustEmail());
			row.createCell(4).setCellValue(customer.getCustAddr());
			row.createCell(5).setCellValue(customer.getCustMob());
			
		}
		
		
	}

	private void setHeader(HSSFSheet sheet) {
					int rownum=0;
					HSSFRow row = sheet.createRow(rownum);
					row.createCell(0).setCellValue("Id");
					row.createCell(1).setCellValue("Name");
					row.createCell(2).setCellValue("Type");
					row.createCell(3).setCellValue("Email");
					row.createCell(4).setCellValue("Address");
					row.createCell(5).setCellValue("mobile");
		
	}

}

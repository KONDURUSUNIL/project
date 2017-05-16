package com.risha.controller.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.risha.model.Vendor;

public class VendorExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			List<Vendor> venlist = (List<Vendor>)map.get("listVen");
			
			HSSFSheet sheet = book.createSheet();
			
			setHeader(sheet);
			
			setBody(sheet,venlist);
			
		

	}

	private void setBody(HSSFSheet sheet, List<Vendor> venlist) {
		int rownum=1;
		for (Vendor vendor : venlist) {
			HSSFRow row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(vendor.getId());
			row.createCell(1).setCellValue(vendor.getName());
			row.createCell(2).setCellValue(vendor.getEmail());
			row.createCell(3).setCellValue(vendor.getAddr());
			row.createCell(4).setCellValue(vendor.getGen());
		}
		
		
	}

	private void setHeader(HSSFSheet sheet) {
			int rownum=0;
			HSSFRow row = sheet.createRow(rownum);
			row.createCell(0).setCellValue("Id");
			row.createCell(1).setCellValue("Name");
			row.createCell(2).setCellValue("Email");
			row.createCell(3).setCellValue("Address");
			row.createCell(4).setCellValue("Gender");
		
	}

}

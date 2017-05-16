package com.risha.controller.views;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.risha.model.Location;

public class LocationExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		List<Location> locList  = (List<Location>)map.get("listLoc");
		
		HSSFSheet sheet = book.createSheet();
		
		setHeader(sheet);
		
		setBody(sheet,locList);
		
	}

	private void setBody(HSSFSheet sheet, List<Location> locList) {
		
		int rownum=1;
		for (Location location : locList) {
			HSSFRow row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(location.getLocId());
			row.createCell(1).setCellValue(location.getLocName());
			row.createCell(2).setCellValue(location.getLocType());
			row.createCell(3).setCellValue(location.getLocSup());
			row.createCell(4).setCellValue(location.getLocAdv());
			row.createCell(5).setCellValue(location.getLocCou());
			row.createCell(6).setCellValue(location.getLocSta());
			row.createCell(7).setCellValue(location.getLocPin());
		}
		
	}

	private void setHeader(HSSFSheet sheet) {
		
		int rownum = 0;
		HSSFRow row = sheet.createRow(rownum);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Type");
		row.createCell(3).setCellValue("Supervisior");
		row.createCell(4).setCellValue("Advisior");
		row.createCell(5).setCellValue("country");
		row.createCell(6).setCellValue("state");
		row.createCell(7).setCellValue("pin");
		
	}

}

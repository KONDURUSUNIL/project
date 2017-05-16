
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
import com.risha.model.Location;


public class LocationPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter pdf, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			//read the data from controller using model map
			List<Location>  listloc= (List<Location>)map.get("listObj");
			
			document.add( new Paragraph("list of locations"));
			
			Table table = new Table(8);
			table.addCell("Id");
			table.addCell("Name");
			table.addCell("Type");
			table.addCell("Supervisior Name");
			table.addCell("Advisior Name");
			table.addCell("state");
			table.addCell("country");
			table.addCell("pincode");
			
			for (Location location : listloc) {
				table.addCell(""+location.getLocId());
				table.addCell(location.getLocName());
				table.addCell(location.getLocType());
				table.addCell(location.getLocSup());
				table.addCell(location.getLocAdv());
				table.addCell(location.getLocSta());
				table.addCell(location.getLocCou());
				table.addCell(""+location.getLocPin());
			}
			
			document.add(table);
	}

}

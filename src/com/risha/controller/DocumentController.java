package com.risha.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.risha.model.FileUpload;
import com.risha.service.IDocumentService;

@Controller
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	@RequestMapping(value="/fileReg",method=RequestMethod.GET)
	public String showDocumentRegistration(ModelMap map){
		
		List<Object[]> listfile = service.getIdAndNamesOnly();
		
		map.addAttribute("listfile", listfile);
		
		return "DocumentRegistration";
	}
		
	@RequestMapping(value="/uploadfile",method=RequestMethod.POST)
	public String uploadDocument(@RequestParam("fileId") int fileId, @RequestParam("fileDtls") CommonsMultipartFile cmf){
		
		
		if(cmf!=null){
			FileUpload fu = new FileUpload();
			fu.setFileId(fileId);
			
			fu.setFileName(cmf.getOriginalFilename());
			fu.setFileData(cmf.getBytes());
			service.saveDocument(fu);
			
		}
			
		return "redirect:fileReg";
		
	}		
	
	
	@RequestMapping(value="/download",method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response ,@RequestParam("fileId") int fileId){
		
		FileUpload file = service.getObjectById(fileId);
		
		response.addHeader("Content-Disposition","attachment;filename="+file.getFileName());
	
		try {
			
			FileCopyUtils.copy(file.getFileData(), response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
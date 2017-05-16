package com.risha.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.risha.dao.IDocumentDao;
import com.risha.model.FileUpload;
import com.risha.service.IDocumentService;
@Service
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private IDocumentDao dao;

	@Override
	public int saveDocument(FileUpload file) {
		
		return dao.saveDocument(file);
	}

	@Override
	public List<Object[]> getIdAndNamesOnly() {
		
		return dao.getIdAndNamesOnly();
	}

	@Override
	public FileUpload getObjectById(int fileId) {
	
		return dao.getObjectById(fileId);
	}

}

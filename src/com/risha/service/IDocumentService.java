package com.risha.service;

import java.util.List;

import com.risha.model.FileUpload;

public interface IDocumentService {
	
	public int saveDocument(FileUpload file);

	public List<Object[]> getIdAndNamesOnly();
	
	public FileUpload getObjectById(int fileId);
	
	
}

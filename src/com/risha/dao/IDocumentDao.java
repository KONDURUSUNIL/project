package com.risha.dao;

import java.util.List;

import com.risha.model.FileUpload;

public interface IDocumentDao {
	
	public int saveDocument(FileUpload file);
	
	public List<Object[]> getIdAndNamesOnly();
	
	public FileUpload getObjectById(int fileId);
	
	

}

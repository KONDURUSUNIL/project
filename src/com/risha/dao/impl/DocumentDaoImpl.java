package com.risha.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.risha.dao.IDocumentDao;
import com.risha.model.FileUpload;

@Repository
public class DocumentDaoImpl  implements IDocumentDao{

	@Autowired
	private HibernateTemplate hibernaTemplate;

	@Override
	public int saveDocument(FileUpload file) {
		
		return (Integer) hibernaTemplate.save(file);
	}

	
	@Override
	public List<Object[]> getIdAndNamesOnly() {
		
		String hql = "select fileId,fileName from " +FileUpload.class.getName();
		
		@SuppressWarnings("unchecked")
		List<Object[]> arrList = hibernaTemplate.find(hql);
		
		return arrList;
	}


	@Override
	public FileUpload getObjectById(int fileId) {
			
		return hibernaTemplate.get(FileUpload.class, fileId);
	}
	
}

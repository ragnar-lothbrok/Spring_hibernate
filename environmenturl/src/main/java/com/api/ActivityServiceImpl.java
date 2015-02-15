package com.api;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.api.ActivityService;
import com.constants.QueryStrings;
import com.home.persistence.HibernateSupportDAO;
import com.mapper.URLDataMapper;
import com.model.TomcatData;
import com.model.URLData;

public class ActivityServiceImpl implements ActivityService{
	
	public static final Logger logger = Logger.getLogger(ActivityServiceImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate ; 
	
	@Autowired
	HibernateSupportDAO hibernateSupportDAO;
	
	public void addTomcatData(TomcatData data) {
		logger.debug("Inside addTomcatData....");
		int status = -1;
		try{
			 int[] types = new int[] {Types.VARCHAR, Types.VARCHAR,Types.VARCHAR};
			jdbcTemplate.update(QueryStrings.INSERT_TOMCAT_DATA, new Object[]{data.getTomcatName(),data.getTomcatPort(),data.getEnvName()},types);
			logger.debug("Add status : "+status);
		}
		catch(Exception exception ){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
	}

	public void updateTomcatData(TomcatData data) {
		logger.debug("Inside update tomcat data....");
		int status = -1;
		try{
			status = jdbcTemplate.update(QueryStrings.UPDATE_TOMCAT_DATA, new Object[]{data.getTomcatName(),data.getTomcatPort(),data.getEnvName(),data.getTomcatDataId()});
			logger.debug("Update status : "+status);
		}
		catch(Exception exception ){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		logger.debug("status : "+status);
	}

	public List<TomcatData> getAllTomcatData() {
		
		List<TomcatData> tomcatDataList = null;
		Session session = null;
		try{
			session = hibernateSupportDAO.getSession();
			Query query = session.createQuery(QueryStrings.GET_TOMCAT_DATA_H);
			tomcatDataList = query.list();  
		}
		catch(Exception exception ){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		finally{
			if(session !=null)
				session.close();
		}
		logger.debug("tomcatDataList : "+tomcatDataList);
		return tomcatDataList;
	}

	public void addURlData(URLData data) {
		logger.debug("Inside addURlData....");
		int status = -1;
		try{
			 jdbcTemplate.update(QueryStrings.INSERT_URL_DATA, new Object[]{data.getEnvName(),data.getProjectName(),data.getModuleName(),data.getModuleLink()});
			 logger.debug("Add status : "+status);
		}
		catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		
	}

	public void updateURLData(URLData data) {
		int status = -1;
		try{
			status = jdbcTemplate.update(QueryStrings.UPDATE_URL_DATA, new Object[]{data.getEnvName(),data.getProjectName(),data.getModuleName(),data.getModuleLink(),data.getUrlDataId()});
		}
		catch(Exception exception ){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		logger.debug("status : "+status);
	}

	public List<URLData> getAllURLData() {
		List<URLData> urlDataList = null;
		try{
			urlDataList = jdbcTemplate.query(QueryStrings.GET_URL_DATA, new URLDataMapper());  
		}
		catch(Exception exception ){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		logger.debug("urlDataList : "+urlDataList);
		return urlDataList;
	}

	public void deleteTomcatData(TomcatData data) {
		logger.debug("Inside deleteTomcatData....");
		int status = -1;
		try{
			 jdbcTemplate.update(QueryStrings.DELETE_TOMCAT_DATA, new Object[]{data.getTomcatDataId()});
			 logger.debug("Delete status : "+status);
		}
		catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
	}

	public void deleteURLData(URLData data) {
		logger.debug("Inside deleteURLData....");
		int status = -1;
		try{
			 jdbcTemplate.update(QueryStrings.DELETE_URL_DATA, new Object[]{data.getUrlDataId()});
			 logger.debug("delete status : "+status);
		}
		catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
	}
	
	public List<TomcatData>  getIndividualTomcatData(int tomcatId){
		List<TomcatData> tomcatDataList = null;
		Session session = null;
		try{
			session = hibernateSupportDAO.getSession();
			Query query = session.createQuery(QueryStrings.GET_TOMCAT_BY_ID_H+tomcatId);
			tomcatDataList = query.list();
			logger.debug("Individual Tomcat Data : "+tomcatDataList);
		}catch(Exception exception){
			logger.error("Excepton Occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
		return tomcatDataList;
	}
	
}

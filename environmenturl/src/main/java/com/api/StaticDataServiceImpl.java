package com.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.StaticDataService;
import com.constants.QueryStrings;
import com.enums.ConfigTypeEnum;
import com.home.persistence.HibernateSupportDAO;
import com.model.StaticData;

public class StaticDataServiceImpl implements StaticDataService{

	public static final Logger logger = Logger.getLogger(StaticDataServiceImpl.class);
	
	@Autowired
	HibernateSupportDAO hibernateSupportDAO;
	
	@Override
	public List<StaticData> getAllStaticData() {
		List<StaticData> configDataList = null;
		Session session = hibernateSupportDAO.getSession();
		try{
			Query query = session.createQuery(QueryStrings.GET_CONFIG_DATA);
			configDataList = query.list();
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
		return configDataList;
	}

	@Override
	public void addStaticData(StaticData staticData) {
		Session session = hibernateSupportDAO.getSession();
		try{
			session.save(staticData);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
	}

	@Override
	public void updateStaticData(StaticData staticData) {
		Session session = hibernateSupportDAO.getSession();
		try{
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(staticData);
			transaction.commit();
			session.flush();
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
	}

	@Override
	public void deleteStaticData(StaticData staticData) {
		Session session = hibernateSupportDAO.getSession();
		try{
			/*Query query = session.createQuery("delete from StaticData where data_id = :id ");
			query.setParameter("id", staticData.getData_id());
			query.executeUpdate();*/
			//Alternate Way to Delete
			Transaction transaction = session.beginTransaction();
			session.delete(staticData);
			transaction.commit();
			session.flush();
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
	}

	@Override
	public List<String> getAllConfigDataTypes() {
		List<String> configTypeList = new ArrayList<String>();
		try{
			for(ConfigTypeEnum configTypeEnum : ConfigTypeEnum.values()){
				configTypeList.add(configTypeEnum.value());
			}
			logger.debug("Config Types : "+configTypeList);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return configTypeList;
	}

}

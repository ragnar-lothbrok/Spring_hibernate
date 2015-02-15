package com.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.DatabaseCredentialApi;
import com.constants.QueryStrings;
import com.home.persistence.HibernateSupportDAO;
import com.model.DatabaseCredential;

public class DatabaseCredentialImpl implements DatabaseCredentialApi{

public static final Logger logger = Logger.getLogger(DatabaseCredentialImpl.class);
	
	@Autowired
	HibernateSupportDAO hibernateSupportDAO;
	
	@Override
	public List<DatabaseCredential> getAlldatabaseCredentials() {
		List<DatabaseCredential> databaseCredentialList = null;
		Session session = hibernateSupportDAO.getSession();
		try{
			Query query = session.createQuery(QueryStrings.GET_DATABASE_CREDENTIAL_DATA);
			databaseCredentialList = query.list();
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
		return databaseCredentialList;
	}

	@Override
	public void adddatabaseCredential(DatabaseCredential databaseCredential) {
		Session session = hibernateSupportDAO.getSession();
		try{
			session.save(databaseCredential);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
	}

	@Override
	public void updatedatabaseCredential(DatabaseCredential databaseCredential) {
		Session session = hibernateSupportDAO.getSession();
		try{
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(databaseCredential);
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
	public void deletedatabaseCredential(DatabaseCredential databaseCredential) {
		Session session = hibernateSupportDAO.getSession();
		try{
			Transaction transaction = session.beginTransaction();
			session.delete(databaseCredential);
			transaction.commit();
			session.flush();
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}finally{
			if(session !=null)
				session.close();
		}
	}

}

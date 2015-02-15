package com.home.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateSupportDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		try {
			Session currentSession=sessionFactory.getCurrentSession();
			if(currentSession==null || !currentSession.isOpen())
				return sessionFactory.openSession();
			else return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}
	
}

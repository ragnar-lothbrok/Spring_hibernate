package com.home.filters;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class ContainerContextClosedHandler implements ServletContextListener{
	
	public static final Logger logger = Logger.getLogger(ContainerContextClosedHandler.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("Context Initialized........");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.debug("Context About to destroy........");
		Enumeration<Driver> drivers = DriverManager.getDrivers();     

		Driver driver = null;
		// clear drivers
		while(drivers.hasMoreElements()) {
			try {
				driver = drivers.nextElement();
				DriverManager.deregisterDriver(driver);

			} catch (SQLException ex) {
				logger.debug("Exception while context About to destroy........");
			}
		}
	}

}

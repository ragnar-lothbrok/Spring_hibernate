package com.home.rest.api;

import java.util.Map;

import com.home.rest.entity.ServiceNetwork;

public interface NetworkService {
	
	//Biz Logic
	public int getServiceNetworkId();
	public ServiceNetwork getServiceNetwork();
	public String getServiceTransactionId();
	public boolean sendNotification();

	//Data setters
	public void setRequestParameterMap(Map<String, String[]> requestParameterMap);
	public void setServiceNetwork(ServiceNetwork adNetwork);
	public NetworkService copy(); //must be overriden
}

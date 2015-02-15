package com.service.api;

import net.wsdl.webservicex.GetGeoIP;
import net.wsdl.webservicex.GetGeoIPContext;
import net.wsdl.webservicex.GetGeoIPContextResponse;
import net.wsdl.webservicex.GetGeoIPResponse;
import net.wsdl.webservicex.ObjectFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.WebServiceTemplate;

public class ConsumerIPServiceClient implements ConsumerIPService{

	public static final Logger logger = Logger.getLogger(ConsumerIPServiceClient.class);
	
	ObjectFactory factory = new ObjectFactory();
	
	@Autowired
	private WebServiceTemplate webServiceTemplate;
	
	@Override
	public GetGeoIPResponse getGeoIPResponse(String ip) {
		GetGeoIP soapRequest = factory.createGetGeoIP();
		GetGeoIPResponse soapResponse = null;
		soapRequest.setIPAddress((ip == null)?"66.220.156.2":ip);
		try{
			Object response =  webServiceTemplate.marshalSendAndReceive(soapRequest);
			if(response != null){
				soapResponse = (GetGeoIPResponse)response;
			}
		}catch(Exception exception){
			logger.error(exception.getMessage(), exception);
		}
		return soapResponse;
	}

	@Override
	public GetGeoIPContextResponse getGeoIPContextResponse() {
		GetGeoIPContext soapRequest = factory.createGetGeoIPContext();
		GetGeoIPContextResponse soapResponse = null;
		try{
			Object response =  webServiceTemplate.marshalSendAndReceive(soapRequest);
			if(response != null){
				soapResponse = (GetGeoIPContextResponse)response;
			}
		}catch(Exception exception){
			logger.error(exception.getMessage(), exception);
		}
		return soapResponse;
	}

}

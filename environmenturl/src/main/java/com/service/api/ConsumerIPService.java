package com.service.api;

import net.wsdl.webservicex.GetGeoIPContextResponse;
import net.wsdl.webservicex.GetGeoIPResponse;

public interface ConsumerIPService {
	GetGeoIPResponse getGeoIPResponse(String ip);
	
	GetGeoIPContextResponse getGeoIPContextResponse();
}

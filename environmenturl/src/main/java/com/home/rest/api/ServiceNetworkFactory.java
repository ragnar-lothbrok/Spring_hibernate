package com.home.rest.api;

import java.util.Map;

public interface ServiceNetworkFactory {
	public NetworkService getAdNetworkService(Map<String, String[]> requestParameterMap);
	public boolean clearCache();
}

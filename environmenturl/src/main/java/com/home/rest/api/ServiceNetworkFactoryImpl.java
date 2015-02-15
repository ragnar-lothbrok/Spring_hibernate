package com.home.rest.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.home.persistence.HibernateSupportDAO;
import com.home.rest.constants.NetworkEnum;
import com.home.rest.entity.ServiceNetwork;

public class ServiceNetworkFactoryImpl implements ServiceNetworkFactory {
	private static final Logger logger = Logger.getLogger(ServiceNetworkFactoryImpl.class);
	
	protected Map <Integer, ServiceNetwork> networkMap = new HashMap<Integer, ServiceNetwork>();
	
	@Autowired
	HibernateSupportDAO hibernateSupportDAO;
	
	@Autowired
	NetworkService defaultAdNetworkService;
	@Autowired
	NetworkService mobbillAdNetworkService;

	@PostConstruct
	public void populateAdNetworkMap() {
		try {
			Session session = hibernateSupportDAO.getSession();
			Query query = null;
			for(NetworkEnum networkEnum : NetworkEnum.values()) {
				query = session.createQuery("from ServiceNetwork where status='active' and serviceNetworkId="+networkEnum.value());
				List<ServiceNetwork> localAdNetworkList = query.list();
				logger.debug("ServiceNetworkId >> "+networkEnum.value()+ "ServiceNetwork>> "+localAdNetworkList);
				if(localAdNetworkList!=null && localAdNetworkList.size() > 0 && localAdNetworkList.get(0).getStatus().equals("active")){
					networkMap.put(networkEnum.value(), localAdNetworkList.get(0));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public NetworkService getAdNetworkService(Map<String, String[]> requestParameterMap) {
		NetworkService networkService = defaultAdNetworkService;
		int networkId = 0;
		for(ServiceNetwork adn : networkMap.values()){
			if(requestParameterMap.containsKey(adn.getRequestParamName())){
				networkId = adn.getServiceNetworkId();
				break;
			}
		}
		if(networkId>0){
			switch (NetworkEnum.fromValue(networkId)) {
			case REST1:
				networkService = mobbillAdNetworkService.copy();
				break;
			default:
				networkService = defaultAdNetworkService.copy();
				break;
			}		
			networkService.setRequestParameterMap(requestParameterMap);
			networkService.setServiceNetwork(networkMap.get(networkId));
		}
		logger.trace("requestParameterMap >> "+requestParameterMap+" NetworkId>> "+networkId+" adNetworkService>> "+networkService);
		return networkService;
	}


	public boolean clearCache() {
		networkMap.clear();	
		return true;
	}

}

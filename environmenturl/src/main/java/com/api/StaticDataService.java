package com.api;

import java.util.List;
import com.model.StaticData;


public interface StaticDataService {
	List<StaticData> getAllStaticData();
	void addStaticData(StaticData staticData);
	void updateStaticData(StaticData staticData);
	void deleteStaticData(StaticData staticData);
	List<String> getAllConfigDataTypes();
}

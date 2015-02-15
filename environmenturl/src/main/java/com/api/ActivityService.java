package com.api;

import java.util.List;

import com.model.TomcatData;
import com.model.URLData;

public interface ActivityService {
	/*
	 * For TomcatData Table
	 */
	 public void addTomcatData(TomcatData data);
	 public void updateTomcatData(TomcatData data);
	 public List<TomcatData> getAllTomcatData();
	 public void deleteTomcatData(TomcatData data);
	 
	 /*
	 * For URLData Table
	 */
	 public void addURlData(URLData data);
	 public void updateURLData(URLData data);
	 public List<URLData> getAllURLData();
	 public void deleteURLData(URLData data);
	 
}

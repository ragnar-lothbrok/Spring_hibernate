package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.ActivityServiceImpl;
import com.model.TomcatData;
import com.model.URLData;

@Controller
@RequestMapping("/report/")
public class ReportController {

	@Autowired
	ActivityServiceImpl activityServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET , value = "/tomcatData/pdf")
	public ModelAndView generateTomcatDetailsPdfView(ModelAndView modelAndView) {

		List<TomcatData> tomcatList =  new ArrayList<TomcatData>();
		tomcatList = activityServiceImpl.getAllTomcatData();
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(tomcatList);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("tomcatpdfReport", parameterMap);

		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.GET , value = "/tomcatData/xls")
	public ModelAndView generateTomcatDetailsXlsView(ModelAndView modelAndView) {
		
		List<TomcatData> tomcatList =  new ArrayList<TomcatData>();
		tomcatList = activityServiceImpl.getAllTomcatData();
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(tomcatList);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("tomcatxlsReport", parameterMap);
		
		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.GET , value = "/tomcatData/html")
	public ModelAndView generateTomcatDetailsHtmlView(ModelAndView modelAndView) {
		
		List<TomcatData> tomcatList =  new ArrayList<TomcatData>();
		tomcatList = activityServiceImpl.getAllTomcatData();
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(tomcatList);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("tomcathtmlReport", parameterMap);
		
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/urlData/pdf")
	public ModelAndView generateURLDetailsPdfView(ModelAndView modelAndView) {

		List<URLData> urlDataList =  new ArrayList<URLData>();
		urlDataList = activityServiceImpl.getAllURLData();
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(urlDataList);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("urlpdfReport", parameterMap);

		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.GET , value = "/urlData/xls")
	public ModelAndView generateURLDetailsXlsView(ModelAndView modelAndView) {
		
		List<URLData> urlDataList =  new ArrayList<URLData>();
		urlDataList = activityServiceImpl.getAllURLData();
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(urlDataList);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("urlxlsReport", parameterMap);
		
		return modelAndView;
	}
	@RequestMapping(method = RequestMethod.GET , value = "/urlData/html")
	public ModelAndView generateURLDetailsHtmlView(ModelAndView modelAndView) {
		
		List<URLData> urlDataList =  new ArrayList<URLData>();
		urlDataList = activityServiceImpl.getAllURLData();
		
		JRDataSource JRdataSource = new JRBeanCollectionDataSource(urlDataList);
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", JRdataSource);
		modelAndView = new ModelAndView("urlhtmlReport", parameterMap);
		
		return modelAndView;
	}
	
}

package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.StaticDataServiceImpl;
import com.model.StaticData;
import com.validator.StaticDataValidator;

@Controller
@RequestMapping("/tool")
public class StaticDataController {
	
	public static final Logger logger = Logger.getLogger(StaticDataController.class);
	
	@Autowired
	StaticDataValidator staticDataValidator;
	
	@Autowired
	StaticDataServiceImpl staticDataServiceImpl;
	
	private static String REDIRECT       = "redirect:/tool/dataMaintenance/showData";
	
	@InitBinder("staticData")
	protected void initStaicDataBinder(WebDataBinder binder) {
	    binder.setValidator(staticDataValidator);
	}
	
	@RequestMapping("/dataMaintenance/addData")
	protected String addData(@Valid StaticData staticData, BindingResult bindingResult, Model model){
		logger.debug("Inside addData : "+staticData);
		try{
			if(bindingResult.hasErrors())
			{
				logger.debug("Errors are present while adding url data... "+bindingResult.hasErrors()+" Error Count : "+bindingResult.getErrorCount());
				model.addAttribute("configTypeList",staticDataServiceImpl.getAllConfigDataTypes());
				return "errorConfigData";
			}
			if(staticData != null && staticData.getData_type() != null && staticData.getData_value() != null)
				staticDataServiceImpl.addStaticData(staticData);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return REDIRECT;
	}
	
	@RequestMapping("/dataMaintenance/showData")
	protected String showData(Model model){
		logger.debug("Inside showData : ");
		try{
			List<StaticData> staticDataList = staticDataServiceImpl.getAllStaticData();
			model.addAttribute("configTypeList",staticDataServiceImpl.getAllConfigDataTypes());
			model.addAttribute("staticDataList", staticDataList);
			StaticData staticData = new StaticData();
			model.addAttribute("staticData",staticData );
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return "showConfigData";
	}
	
	@RequestMapping("/dataMaintenance/updateData")
	protected String updateData(@Valid StaticData staticData,HttpServletRequest request){
		logger.debug("Inside updateData : "+staticData);
		try{
			staticDataServiceImpl.updateStaticData(staticData);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return REDIRECT;
	}
	
	@RequestMapping("/dataMaintenance/deleteData")
	protected String deleteData(@Valid StaticData staticData,HttpServletRequest request){
		logger.debug("Inside deleteData : "+staticData);
		try{
			staticDataServiceImpl.deleteStaticData(staticData);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return REDIRECT;
	}
}

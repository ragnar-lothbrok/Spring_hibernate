package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.ActivityService;
import com.enums.ConfigTypeEnum;
import com.model.URLData;
import com.util.DataUtil;
import com.validator.URLDetailValidator;

@Controller
@RequestMapping("/tool")
public class URLDataController {
	public static final Logger logger = Logger.getLogger(URLDataController.class);
	
	@Autowired
	ActivityService activityServiceImpl;
	
	@Autowired
	URLDetailValidator uRLDetailValidator;
	
	@Autowired
	DataUtil dataUtil;
	
	private static String REDIRECT       = "redirect:/tool/urldata/showURLData";
	
	@InitBinder("uRLData")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uRLDetailValidator);
	}
	
	@RequestMapping("/urldata/showURLData")
	public String showURLData(Model model){
		try{
			logger.debug("Inside showURLData...");
			List<URLData> urlDataDetail = activityServiceImpl.getAllURLData();
			model.addAttribute("urlDataDetail", urlDataDetail);
			model.addAttribute("moduleTypeList", dataUtil.getConfigTypes(ConfigTypeEnum.MODULE_NAME.value()));
			URLData uRLData = new URLData();
			model.addAttribute("uRLData", uRLData);
		}catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
			exception.getStackTrace();
		}
		return "showURLDetails";
	}
	
	@RequestMapping("/urldata/addURLData")
	public String addURLData(@Valid URLData uRLData, BindingResult bindingResult, Model model, HttpServletRequest request,HttpServletResponse response){
		logger.debug("Inside addURLData....");
		if(bindingResult.hasErrors())
		{
			logger.debug("Errors are present while adding url data... "+bindingResult.hasErrors()+" Error Count : "+bindingResult.getErrorCount());
			model.addAttribute("moduleTypeList", dataUtil.getConfigTypes(ConfigTypeEnum.MODULE_NAME.value()));
			return "errorURLData";
		}
		if(uRLData != null && uRLData.getEnvName() != null && StringUtils.hasText(uRLData.getEnvName()) && StringUtils.hasText(uRLData.getModuleLink())){
			logger.debug("Action : ADD URL DATA , Data : "+uRLData.toString());
			activityServiceImpl.addURlData(uRLData);
		}
		return REDIRECT;
	}
	
	@RequestMapping("/urldata/deleteURLData")
	public String deleteURLData(@ModelAttribute("uRLData") URLData uRLData,Model model, HttpServletRequest request){
		logger.debug("Inside deleteURLData....");
		if(uRLData != null){
			logger.debug("Action : Delete URL DATA , Data : "+uRLData.toString());
			activityServiceImpl.deleteURLData(uRLData);
		}
		return REDIRECT;
	}
	
	@RequestMapping("/urldata/updateURLData")
	public String updateURLData(@ModelAttribute("uRLData") URLData uRLData,Model model, HttpServletRequest request){
		logger.debug("Inside updateURLData....");
		if(uRLData != null){
			logger.debug("Action : UPDATE URL DATA , Data : "+uRLData.toString());
			activityServiceImpl.updateURLData(uRLData);
		}
		return REDIRECT;
	}
	
	@RequestMapping("/urldata/error")
	public String getErrorPage(Model model,HttpServletRequest request,HttpServletResponse response){
		try{
			logger.debug("Inside getErrorPage..."+activityServiceImpl);
			URLData uRLData = new URLData();
			model.addAttribute("uRLData", uRLData);
		}catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		return "showURLDetails";
	}
	
}

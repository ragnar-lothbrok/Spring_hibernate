package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.ActivityServiceImpl;
import com.enums.ConfigTypeEnum;
import com.model.TomcatData;
import com.util.DataUtil;
import com.validator.TomcatDataValidator;

@Controller
@RequestMapping("/tool")
public class TomcatDataController {
	
	@Autowired
	ActivityServiceImpl activityServiceImpl;
	
	@Autowired
	TomcatDataValidator tomcatDataValidator;
	
	@Autowired
	DataUtil dataUtil;
	
	
	public static final Logger logger = Logger.getLogger(TomcatDataController.class);
	private static String REDIRECT       = "redirect:/tool/tomcatdata/showTomcatData";
	
	@InitBinder("tomcatData")
	protected void initTomcatDataBinder(WebDataBinder binder) {
	    binder.setValidator(tomcatDataValidator);
	}
	
	
	@RequestMapping("/tomcatdata/showTomcatData")
	public String showTomcatData(Model model){
		try{
			logger.debug("Inside getTomcatData...");
			model.addAttribute("environmentTypeList", dataUtil.getConfigTypes(ConfigTypeEnum.ENVIRONMENT_NAME.value()));
			List<TomcatData> tomcatDataDetail = activityServiceImpl.getAllTomcatData();
			model.addAttribute("tomcatDataDetail", tomcatDataDetail);
			TomcatData tomcatData = new TomcatData();
			model.addAttribute("tomcatData", tomcatData);
		}catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
			exception.getStackTrace();
		}
		return "showTomcatDetails";
	}
	
	@RequestMapping("/tomcatdata/error")
	public String getErrorPage(Model model,HttpServletRequest request,HttpServletResponse response){
		try{
			logger.debug("Inside getErrorPage..."+activityServiceImpl);
			TomcatData tomcatData = new TomcatData();
			model.addAttribute("tomcatData", tomcatData);
			checkOperations(request,response);
		}catch(Exception exception){
			logger.debug("Excepton Occured : "+exception.getStackTrace());
		}
		return "showTomcatDetails";
	}
	
	@RequestMapping("/tomcatdata/addTomcatData")
	public String addTomcatData(@Valid TomcatData tomcatData, BindingResult bindingResult, Model model, HttpServletRequest request,HttpServletResponse response){
		logger.debug("Inside addTomcatData....");
		if(bindingResult.hasErrors())
		{
			logger.debug("Errors are present while adding tomcat data... "+bindingResult.hasErrors()+" Error Count : "+bindingResult.getErrorCount());
			model.addAttribute("environmentTypeList", dataUtil.getConfigTypes(ConfigTypeEnum.ENVIRONMENT_NAME.value()));
			return "errorTomcatData";
		}
		if(tomcatData != null){
			logger.debug("Action : ADD TOMCAT DATA , Data : "+tomcatData.toString());
			activityServiceImpl.addTomcatData(tomcatData);
		}
		return REDIRECT;
	}
	
	@RequestMapping("/tomcatdata/deleteTomcatData")
	public String deleteTomcatData(@ModelAttribute("tomcatData") TomcatData tomcatData, Model model, HttpServletRequest request){
		logger.debug("Inside deleteTomcatData....");
		if(tomcatData != null){
			logger.debug("Action : DELETE URL DATA , Data : "+tomcatData.toString());
			activityServiceImpl.deleteTomcatData(tomcatData);
		}
		return REDIRECT;
	}
	
	@RequestMapping("/tomcatdata/updateTomcatData")
	public String updateTomcatData(@ModelAttribute("tomcatData") TomcatData tomcatData, Model model, HttpServletRequest request){
		logger.debug("Inside updateTomcatData....");
		if(tomcatData != null){
			logger.debug("Action : UPDATE URL DATA , Data : "+tomcatData.toString());
			activityServiceImpl.updateTomcatData(tomcatData);
		}
		return REDIRECT;
	}
	
	private void checkOperations(HttpServletRequest request,HttpServletResponse response){
		String action= request.getParameter("action");
		logger.debug("Action : "+action);
		RequestDispatcher dispatcher = request.getRequestDispatcher("detail");
		try{
			if("forward".equalsIgnoreCase(action)){
				dispatcher.forward(request, response);
			}else if("include".equalsIgnoreCase(action)){
				dispatcher.include(request, response);
			}else if("redirect".equalsIgnoreCase(action)){
				response.sendRedirect("detail");
			}
		}catch (ServletException e) {
			logger.debug("Exception occured : "+e.getStackTrace());
		} catch (IOException e) {
			logger.debug("Exception occured : "+e.getStackTrace());
		}
		logger.debug("Executed everything.........");
	}
	
	/*
	 * Using this in Ajax
	 */
	@RequestMapping(value="/tomcatdata/fetchTomcatInfo" , method = RequestMethod.GET)
	@ResponseBody
	private String fetchTomcatInfo(HttpServletRequest request,HttpServletResponse response){
		activityServiceImpl.getAllTomcatData();
		activityServiceImpl.getAllURLData();
		List<TomcatData> tomcatDataList = activityServiceImpl.getIndividualTomcatData(Integer.parseInt(request.getParameter("tomcatId")));
		request.setAttribute("tomcatDataUnit", tomcatDataList);
		return "showTomcatDetails";
	}
}

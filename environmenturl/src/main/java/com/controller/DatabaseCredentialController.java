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

import com.api.DatabaseCredentialApi;
import com.model.DatabaseCredential;
import com.validator.DatabaseCredentialValidator;

@Controller
@RequestMapping("/tool")
public class DatabaseCredentialController {
public static final Logger logger = Logger.getLogger(StaticDataController.class);
	
	@Autowired
	DatabaseCredentialValidator databaseCredentialValidator;
	
	@Autowired
	DatabaseCredentialApi databaseCredentialImpl;
	
	private static String REDIRECT       = "redirect:/tool/databasecredential/showData";
	
	@InitBinder("databaseCredential")
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(databaseCredentialValidator);
	}
	
	@RequestMapping("/databasecredential/addData")
	protected String addData(@Valid DatabaseCredential databaseCredential, BindingResult bindingResult, Model model){
		logger.debug("Inside addData : "+databaseCredential);
		try{
			if(bindingResult.hasErrors())
			{
				logger.debug("Errors are present while adding credentials data... "+bindingResult.hasErrors()+" Error Count : "+bindingResult.getErrorCount());
				return "errorDatbaseCredential";
			}
			if(databaseCredential != null && databaseCredential.getDatabase_name() != null && databaseCredential.getDatabase_ip() != null
					&& databaseCredential.getDatabase_username() != null && databaseCredential.getDatabase_username() != null)
				databaseCredentialImpl.adddatabaseCredential(databaseCredential);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return REDIRECT;
	}
	
	@RequestMapping("/databasecredential/showData")
	protected String showData(Model model){
		logger.debug("Inside showData : ");
		try{
			List<DatabaseCredential> databaseCredentialList = databaseCredentialImpl.getAlldatabaseCredentials();
			model.addAttribute("databaseCredentialList", databaseCredentialList);
			DatabaseCredential databaseCredential = new DatabaseCredential();
			model.addAttribute("databaseCredential",databaseCredential);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return "databasecredentialData";
	}
	
	@RequestMapping("/databasecredential/updateData")
	protected String updateData(@Valid DatabaseCredential databaseCredential,HttpServletRequest request){
		logger.debug("Inside updateData : "+databaseCredential);
		try{
			databaseCredentialImpl.updatedatabaseCredential(databaseCredential);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return REDIRECT;
	}
	
	@RequestMapping("/databasecredential/deleteData")
	protected String deleteData(@Valid DatabaseCredential databaseCredential,HttpServletRequest request){
		logger.debug("Inside deleteData : "+databaseCredential);
		try{
			databaseCredentialImpl.deletedatabaseCredential(databaseCredential);
		}catch(Exception exception){
			logger.error("Exception occured : "+exception.getStackTrace());
		}
		return REDIRECT;
	}
}

package com.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.api.ConsumerIPService;
import com.service.api.CurrencyService;

@Controller
@RequestMapping("/tool")
public class MenuController {

	public static final Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired
	ConsumerIPService consumerIPService;
	
	@Autowired
	CurrencyService currencyService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadAllMenu(Model model) 
	{
		logger.debug("Inside Menu Controller...");
		consumerIPService.getGeoIPResponse(null);
		consumerIPService.getGeoIPContextResponse();
		currencyService.getConversionRate("USD", "INR");
		return "tool_menu";
	}
}

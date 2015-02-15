package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enums.ConfigTypeEnum;
import com.util.DataUtil;

@Controller
@RequestMapping("/tool")
public class MsisdnController {

	@Autowired
	DataUtil dataUtil;

	public static final Logger logger = Logger.getLogger(MsisdnController.class);

	@RequestMapping("/msisdndetail/showmsisdndetail")
	public String OperationOnMsisdn(HttpServletRequest request,HttpServletResponse response){
		logger.debug("Inside OperationOnMsisdn....");
		String msisdn = request.getParameter("msisdn");
		String action = request.getParameter("action");
		request.setAttribute("msisdnoperations", dataUtil.getConfigTypes(ConfigTypeEnum.MSISDN_OPERATON.value()));
		if(action == null)
			return "showmsisdndetail";
		if(msisdn == null || msisdn.trim().length() == 0)
			request.setAttribute("emptymsisdn", "MSISDN field can't be empty.");
		String encryptedMsisdn = null;
		String decryptedMsisdn = null;
		if(action != null && action.equalsIgnoreCase("ENCRYPT"))
		{
			decryptedMsisdn = msisdn;
			encryptedMsisdn = dataUtil.encrypt(msisdn);
		}
		else if(action != null && action.equalsIgnoreCase("DECRYPT")){
			encryptedMsisdn = msisdn;
			decryptedMsisdn = dataUtil.decrypt(msisdn);
		}
		request.setAttribute("decryptedMsisdn", decryptedMsisdn);
		request.setAttribute("encryptedMsisdn", encryptedMsisdn);
		logger.debug("decryptedMsisdn : "+decryptedMsisdn+" encryptedMsisdn : "+encryptedMsisdn+" msisdn : "+msisdn+" Action : "+action);
		return "showmsisdndetail";
	}

}

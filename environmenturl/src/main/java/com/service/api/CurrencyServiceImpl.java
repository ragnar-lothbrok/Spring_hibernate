package com.service.api;

import net.webservicex.ConversionRate;
import net.webservicex.ConversionRateResponse;
import net.webservicex.Currency;
import net.webservicex.ObjectFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

public class CurrencyServiceImpl implements CurrencyService{
	
	public static final Logger logger = Logger.getLogger(CurrencyServiceImpl.class);
	
	ObjectFactory factory = new ObjectFactory();
	
	@Autowired
	private WebServiceTemplate webServiceTemplate2;
	
	@Autowired
	Marshaller currencyMarshaller;
	
	public ConversionRateResponse getConversionRate(String ccy1,String ccy2){
		ConversionRateResponse conversionRateResponse = null;
		try{
			ConversionRate conversionRate = factory.createConversionRate();
			conversionRate.setFromCurrency(Currency.valueOf(ccy1));
			conversionRate.setToCurrency(Currency.valueOf(ccy2));
			
			Object response = webServiceTemplate2.marshalSendAndReceive(conversionRate);
			if(response != null){
				conversionRateResponse = (ConversionRateResponse) response;
			}
		}catch(Exception exception){
			logger.error(exception.getMessage(), exception);
		}
		return conversionRateResponse;
	}
	
}

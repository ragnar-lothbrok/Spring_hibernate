package com.service.api;

import net.webservicex.ConversionRateResponse;

public interface CurrencyService {
	ConversionRateResponse getConversionRate(String ccy1,String ccy2);
}

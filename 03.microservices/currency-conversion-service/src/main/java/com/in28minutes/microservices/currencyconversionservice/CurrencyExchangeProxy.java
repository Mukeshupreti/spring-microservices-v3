package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange", url="localhost:8000")
// you can remove url only if currency exchange/conversion conversion is eureka client
// so they can do load balancing by reading name="currency-exchange" from eureka server.

// notice here name="currency-exchange" as it feign client of currency exchange.
@FeignClient(name="currency-exchange") // for this without url you should have eureka server must be running
// and currency exchange must be register to eureka server

public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);

}

package com.cg.trg.springapp.Springapp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {
	@Autowired
	RateProvider rp;
	
	double toRupees(String symbol, double amount) {
		
		return amount*rp.getRate(symbol);
		
	}

	double fromRupees(String symbol, double amount) {

		return amount/rp.getRate(symbol);
	}

}

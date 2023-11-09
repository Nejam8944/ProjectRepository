package com.cg.trg.springapp.Springapp3;

import org.springframework.stereotype.Service;

@Service
public class RateProvider {
	
	double getRate(String symbol){
		switch (symbol) {
		
		case "SGD":return 60.1;

		case "USD":return 83.24;
					
					
		case "EUR":return 88.44;
					

		case "YEN":return 0.55;
					

		default:   return 1;
		}
	}
}

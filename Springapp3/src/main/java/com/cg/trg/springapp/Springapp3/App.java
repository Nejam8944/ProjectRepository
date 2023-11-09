package com.cg.trg.springapp.Springapp3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.cg")
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
		Scanner sc = new Scanner(System.in);

		CurrencyConverter converter = ctx.getBean("currencyConverter", CurrencyConverter.class);
//    	CurrencyConverter converter=(CurrencyConverter) ctx.getBean("currencyConverter");.
		boolean condition = true;
		List<String> currencyList = Arrays.asList(new String[] { "SGD", "USD", "YEN", "EUR" });

		while (condition) {
			System.out.println("Choose a Service");
			System.out.println("1.To Rupees \n2.From Rupees");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter Currency code shown below");
				System.out.println(currencyList);
				String code = sc.next();
				System.out.println("Enter Amount");
				int amount = sc.nextInt();
				System.out.println(amount + " " + code + " = " + converter.toRupees(code.toUpperCase(), amount) + " rupees");
				break;
			}

			case 2: {
				System.out.println("Enter Currency code shown below");
				System.out.println(currencyList);
				String code = sc.next();
				System.out.println("Enter Amount");
				int amount = sc.nextInt();
				System.out.println(amount + " rupees =" + converter.fromRupees(code.toUpperCase(), amount) + " " + code);
				break;
			}
			default:
				System.out.println("Invalid Choice");
				break;
			}

			System.out.print("continue y/n: ");
			String s = sc.next();
			if (s.equals("y") || s.equals("Y")) {
				condition = true;
			} else {
				condition = false;
			}

		}

	}

}
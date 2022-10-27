package com.cfe.springapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class HelloWorldController {

	@RequestMapping("/")
	public String index() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return "Greetings from Spring Boot! .. date: "+formatter.format(date)+ " ... "+date;
	}
}
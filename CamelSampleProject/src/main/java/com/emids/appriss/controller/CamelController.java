package com.emids.appriss.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {

	@Autowired
	ProducerTemplate producerTemplate;

	@RequestMapping(value = "/camel")
	public String startCamelRoute() {
		
		producerTemplate.sendBody("direct:firstRoute", "Calling via Spring Boot Rest Controller");
		return "Calling via Spring Boot Rest Controller  with Camel route";
		
	}
}

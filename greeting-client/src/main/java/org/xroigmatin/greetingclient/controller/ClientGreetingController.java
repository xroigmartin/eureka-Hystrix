package org.xroigmatin.greetingclient.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.xroigmatin.greetingclient.model.Greeting;
import org.xroigmatin.greetingclient.service.ClientGreetingService;

@RestController
public class ClientGreetingController {

	protected ClientGreetingService helloWorldService;

	protected Logger logger = Logger.getLogger(ClientGreetingController.class
			.getName());

	//constructor
	public ClientGreetingController(ClientGreetingService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	@GetMapping("greeting")
	public String hola() {
		return "hola";
	}
	
	@GetMapping("/greeting/{name}")
	public String greeting(@PathVariable("name") String name) {
	
		logger.info("helloWorld-service greeting() invoked: " + name);

		Greeting greeting = helloWorldService.greeting(name);
		
		logger.info("helloWorld-service greeting() found: " + greeting.getContent());
	
		return greeting.getContent();
		
	}
}

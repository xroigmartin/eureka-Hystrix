package org.xroigmatin.greetingserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.xroigmatin.greetingserver.model.Greeting;

@RestController
public class GreetingController {
	
	private static final String template ="Hello, %s";
	
	@GetMapping("/greeting/{name}")
	public Greeting greeting(@PathVariable("name") String name) {
		return new Greeting(String.format(template, name));
	}

}

package org.xroigmatin.greetingclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.client.RestTemplate;
import org.xroigmatin.greetingclient.model.Greeting;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class ClientGreetingService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	protected Greeting greeting;
	
	public ClientGreetingService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}
	
	@HystrixCommand(fallbackMethod = "greetingDefault")
	public Greeting greeting (String name) {
		System.out.println(serviceUrl + "/greeting/{name}");
		return restTemplate.getForObject(serviceUrl + "/greeting/{name}",Greeting.class, name);
	}
	
	public Greeting greetingDefault(String name) {
		return new Greeting("Hello World thanks to Circuit Braker(Hystrix)");
	}
}

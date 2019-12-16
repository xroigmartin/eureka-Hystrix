package org.xroigmatin.greetingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.xroigmatin.greetingclient.controller.ClientGreetingController;
import org.xroigmatin.greetingclient.service.ClientGreetingService;

@SpringBootApplication
@EnableDiscoveryClient
//Habilita la Hydrix para el patron circuit braker
@EnableCircuitBreaker
@ComponentScan(useDefaultFilters = false)
public class GreetingClientApplication {
	
	public static final String SERVICE_URL = "GREETING-SERVICE";

	public static void main(String[] args) {
		SpringApplication.run(GreetingClientApplication.class, args);
	}

	//Habilita el load balanced de eureka
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ClientGreetingService helloWorldService() {
		return new ClientGreetingService(SERVICE_URL);
	}
	
	@Bean
	public ClientGreetingController helloWorldController() {
		return new ClientGreetingController(helloWorldService());
	}
}

package org.xroigmatin.greetingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
//Indica que el microservicio se registre en eureka
@EnableDiscoveryClient
public class GreetingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServerApplication.class, args);
	}

}

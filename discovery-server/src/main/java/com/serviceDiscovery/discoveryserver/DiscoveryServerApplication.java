package com.serviceDiscovery.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //it tells spring boot that this is a eureka server not part of start.spring.io
					//every eureka server is also a eureka client when it runs it not only provides registry it also tries to register with other
					//eureka servers beacuse we can not only have multiple intances of microservices but also eureka server and then they can register with each other so if one fails other one can provide with
					//discovery service.
public class DiscoveryServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}

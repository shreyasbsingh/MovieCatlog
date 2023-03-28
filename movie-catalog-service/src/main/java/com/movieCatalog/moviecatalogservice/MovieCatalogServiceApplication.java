package com.movieCatalog.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {
	@Bean //it could be use anywhere in application and use Di to call it accross the application.
	@LoadBalanced //it does service discovery in a loadbalanced way
	//it makes resttemplate look for hints to services to call which is there in eureka server from the url so the part in url which replaces the localhost is hint and searched for
	//in the eureka server.
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	/* @Bean //same stuff as above and use it as autowired property.
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}*/ //create a bulilder use it to build a client everytime u make a call.everytime you make a call you build the client put the parameter and then go.
	public static void main(String[] args) {

		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

}

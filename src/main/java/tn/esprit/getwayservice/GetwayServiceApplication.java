package tn.esprit.getwayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication


public class GetwayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetwayServiceApplication.class, args);
	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/api/etudiants/**").uri("lb://MS1ETUDIANT"))
				.route(p -> p.path("/api/foyers/**").uri("lb://MS2FOYER"))
				.build();
	}

}

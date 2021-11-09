package com.handson.gateway.components;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class RoutingConfig {
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	            .path("/get")
	            .filters(f -> f.addRequestHeader("Hello", "World"))
	            .uri("http://httpbin.org:80"))
	        .route("product_client", r -> r.path("/product/**")
                    .uri("http://localhost:8099/"))
	        .build();
	}

}

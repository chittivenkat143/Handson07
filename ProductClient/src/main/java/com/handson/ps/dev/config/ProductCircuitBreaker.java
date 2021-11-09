package com.handson.ps.dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.handson.ps.dev.network.ProductServiceNetwork;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import io.github.resilience4j.ratelimiter.RateLimiter;

//@Configuration
public class ProductCircuitBreaker {
	
	@Bean
	public CircuitBreaker getCircuitBreaker() {
		return CircuitBreaker.ofDefaults("productService");
	}
	
	@Bean
	public RateLimiter getRateLimiter() {
		return RateLimiter.ofDefaults("productService");
	}
	
	@Bean
	public FeignDecorators getFeignDecorators() {
		return FeignDecorators.builder().withRateLimiter(getRateLimiter())
				.withCircuitBreaker(getCircuitBreaker()).build();
	}
	
	@Bean
	public ProductServiceNetwork getProductServiceNetwork() {
		return Resilience4jFeign.builder(getFeignDecorators()).target(ProductServiceNetwork.class, "http://localhost:8098");
	}

}

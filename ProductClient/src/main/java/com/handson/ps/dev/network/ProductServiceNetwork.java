package com.handson.ps.dev.network;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.handson.ps.dev.model.Product;
import com.handson.ps.dev.network.fallback.ProductFallback;

@FeignClient(value = "productClient", url = "http://localhost:8098", path = "/product")
public interface ProductServiceNetwork {
	
	@PostMapping("/add")
	Product addProduct(@RequestBody Product product);
	
	@GetMapping("/{productId}")
	Product getProduct(@PathVariable(value = "productId") Long productId);
	
	@GetMapping("/viewAll")
	List<Product> getAllProducts();
	
	@PostMapping("/delete/{productId}")
	String deleteProduct(@PathVariable(value = "productId") Long productId);
	
	
	default String fallbackProductNotAdded() {
		return "Product not added";
	}
	

	default String fallbackSystemNotAvaliable() {
		return "Product not added";
	}

}

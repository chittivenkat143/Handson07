package com.handson.ps.dev.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.ps.dev.exception.ProductNotFoundException;
import com.handson.ps.dev.model.Product;
import com.handson.ps.dev.network.ProductServiceNetwork;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import feign.Request;

@Service
public class ProductClientService {
	
	@Autowired
	private ProductServiceNetwork serviceNetwork;
	
	@HystrixCommand(fallbackMethod = "fallbackAddProduct")
	public Product addProduct(Product product) {
		return serviceNetwork.addProduct(product);
	}
	
	@HystrixCommand(fallbackMethod = "fallbackGetAllProducts")
	public List<Product> getAllProducts(){
		return serviceNetwork.getAllProducts();
	}
	
	@HystrixCommand(fallbackMethod = "fallbackGetProduct")
	public Product getProduct(Long productId) {
		return serviceNetwork.getProduct(productId);
	}
	
	@HystrixCommand(fallbackMethod = "fallbackDeleteProduct")
	public String deleteProduct(Long productId) {
		return serviceNetwork.deleteProduct(productId);
	}
	
	public Product fallbackAddProduct(Product product) {
		throw new ProductNotFoundException();
	}
	
	public List<Product> fallbackGetAllProducts() {
		return new ArrayList<>();
	}

	
	public Product fallbackGetProduct(Long productId) {
		throw new ProductNotFoundException();
	}
		
	public String fallbackDeleteProduct(Long productId) {
		return "Not able to delete Product";
	}

}

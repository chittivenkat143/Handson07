package com.handson.ps.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.handson.ps.dev.model.Product;
import com.handson.ps.dev.service.ProductClientService;

@RestController
@RequestMapping("/product")
public class ProductClientController {

	@Autowired
	private ProductClientService serviceProduct;
	
	@GetMapping("/{productId}")
	public Product getProductDetails(@PathVariable(value = "productId") Long productId){
		return serviceProduct.getProduct(productId);
	}
		
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return serviceProduct.addProduct(product);
	}
	
	@PostMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") Long productId) {
		serviceProduct.deleteProduct(productId);
		return "Deleted Succesfully";
	}
	
	@GetMapping("/viewAll")
	public List<Product> getAllProducts(){
		return serviceProduct.getAllProducts();
	}
}

package com.handson.ps.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.handson.ps.dev.model.Product;
import com.handson.ps.dev.service.ProductService;

@RestController
@RefreshScope
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Value("${spring.application.name}")
	public String nameOfApplication;
	
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@GetMapping("/nameOfApp")
	public String getApplicationName() {
		return nameOfApplication + "-\t" + activeProfile;
	}
	
	@GetMapping("/{productId}")
	public Product getProductDetails(@PathVariable(value = "productId") Long productId){
		return productService.getProduct(productId);
	}
		
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		product.setId(Long.parseLong(getSixDigit()));
		return productService.productAdd(product);
	}
	
	@PostMapping("/delete/{productId}")
	public String deleteProduct(@PathVariable(value = "productId") Long productId) {
		productService.productDelete(productId);
		return "Deleted Succesfully";
	}
	
	@GetMapping("/viewAll")
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
	}
	
	public String getSixDigit() {
		return String.format("%06d", productService.generateSixDigit());
	}
	
}

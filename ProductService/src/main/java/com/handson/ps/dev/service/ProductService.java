package com.handson.ps.dev.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.ps.dev.model.Product;
import com.handson.ps.dev.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product productAdd(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public void productDelete(Long productId) {
		productRepository.deleteById(productId);
	}
	
	public Product getProduct(Long productId) {
		return productRepository.findById(productId).get();
	}
	
	
	public Long generateSixDigit() {
		return (long) new Random().nextInt(999999);
	}
}

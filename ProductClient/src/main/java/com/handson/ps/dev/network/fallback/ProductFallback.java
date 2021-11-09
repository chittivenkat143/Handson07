package com.handson.ps.dev.network.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.handson.ps.dev.model.Product;
import com.handson.ps.dev.network.ProductServiceNetwork;

@Component
public class ProductFallback implements ProductServiceNetwork{

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}

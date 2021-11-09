package com.handson.ps.dev.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {
	
	private Long id;
	
	private String productName;
	
	private Integer quantity;

	private String brand;
	
	private double price;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiryDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date manufacturedDate;
	
	public Product() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getManufacturedDate() {
		return manufacturedDate;
	}
	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", quantity=" + quantity + ", brand=" + brand
				+ ", price=" + price + ", expiryDate=" + expiryDate + ", manufacturedDate=" + manufacturedDate + "]";
	}
	
	

}

package com.handson.ps.dev.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 6)
	private Long id;
	
	@Column(name="product_name", nullable = false, length = 5)
	private String productName;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="price")
	private double price;
	
	@Column(name="expiry_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiryDate;
	
	@Column(name="manufactured_date")
	@Temporal(TemporalType.DATE)
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

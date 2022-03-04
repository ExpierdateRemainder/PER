package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="product")
public class Product {
	 @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "product_id")
	  private Long id;
	 
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name = "user_id")
	  @JsonManagedReference
	  private User user;
	  
	  @Column(name="product_name")
	  private String productName;
	  
	  @Column(name="expiryDate")
	  private String expiryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Product() {
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", user=" + user + ", productName=" + productName + ", expiryDate=" + expiryDate
				+ "]";
	}

	
	  
	  
	  
	  

}

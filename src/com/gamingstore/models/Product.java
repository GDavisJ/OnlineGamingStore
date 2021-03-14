package com.gamingstore.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodId;

    @Size(min = 1, message = " Product name is a required field")
	private String productName;
    
    @Size(min = 1, message = " Product description is a required field")
	private String productDescription;

    @Min(value = 0, message = "Product quantity needs to be greater than or equal to 0")
	private Integer productQuantity;
    

	private double productPrice;
	
	public Product() {
		super();
		this.prodId = null;
		this.productName = "";
		this.productDescription = "";
		this.productQuantity = 0;
		this.productPrice = 0.00;
	}
	
	public Product(Integer prodId, String productName, String productDescription, Integer productQuantity, double productPrice) {
		super();
		this.prodId = prodId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


}

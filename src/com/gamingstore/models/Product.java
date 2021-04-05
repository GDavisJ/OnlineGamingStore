package com.gamingstore.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


/**Product object used to store product information.*/
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
	
	/**Product constructor to set default values.*/
	public Product() {
		super();
		this.prodId = null;
		this.productName = "";
		this.productDescription = "";
		this.productQuantity = 0;
		this.productPrice = 0.00;
	}
	
	/**Product constructor that takes arguments.*/
	public Product(Integer prodId, String productName, String productDescription, Integer productQuantity, double productPrice) {
		super();
		this.prodId = prodId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
	}

	/**Method used to get the product ID.*/
	public Integer getProdId() {
		return prodId;
	}

	/**Method used to set the product ID.*/
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	/**Method used to get the product name.*/
	public String getProductName() {
		return productName;
	}

	/**Method used to set the product name.*/
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	/**Method used to get the product description.*/
	public String getProductDescription() {
		return productDescription;
	}

	/**Method used to set the product description.*/
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**Method used to get the product quantity.*/
	public Integer getProductQuantity() {
		return productQuantity;
	}

	/**Method used to set the product quantity.*/
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**Method used to get the product Price.*/
	public double getProductPrice() {
		return productPrice;
	}

	/**Method used to set the product Price.*/
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


}
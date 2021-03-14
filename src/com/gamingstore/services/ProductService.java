package com.gamingstore.services;

import java.util.List;

import com.gamingstore.models.Product;

public interface ProductService {

  int registerProduct(Product product);
  
  boolean  checkProduct(Product product);
  
  List<Product> getProducts();
  
  Product getProduct(int prodId);
  
  int deleteProduct(int prodId);
  
  public int updateProduct(Product product);
}

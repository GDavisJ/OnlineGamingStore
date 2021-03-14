package com.gamingstore.dao;

import java.util.List;

import com.gamingstore.models.Product;

public interface ProductDao {

  int registerProduct(Product product);
  
  boolean checkProduct(Product product);
  
  List<Product> getProducts();
  
  int deleteProduct(int prodId);
  
  Product getProduct(int prodId);
  
  public int updateProduct(Product product);
}

package com.gamingstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gamingstore.models.Product;

public class ProductDaoImpl implements ProductDao {	
  //inject the DataSource
  @Autowired
  DataSource datasource;
  //inject the jdbcTemplate
  @Autowired
  JdbcTemplate jdbcTemplate;

  //Adds a new product to the database.
  public int registerProduct(Product product) {
    String sql="insert into gaming_db.products(productName, productDescription, productQuantity, productPrice) VALUES ('"+product.getProductName()+"','"+product.getProductDescription()+"',"+product.getProductQuantity()+","+product.getProductPrice()+")";  
    return jdbcTemplate.update(sql);
  }
  
  //Checks if the product name already exists in the database. 
  public boolean checkProduct(Product product) {
	  String sql="select * from gaming_db.products where productName='" + product.getProductName() +"'";
	  List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
	  if(products.size() > 0)
	  {
		  return true;
	  }
	  return false;
  }

  //Returns a list of products in the database.
  public List<Product> getProducts() {
	  String sql="select * from gaming_db.products";
	  List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
	  return products;
  }
  
  
  //Checks if the product name already exists in the database. 
  public Product getProduct(int prodId) {
	  String sql="select * from gaming_db.products where prodId="+ prodId;
	  return jdbcTemplate.query(sql, new ProductMapper()).get(0);
  }
  
  //Deletes a product in the database.
  public int deleteProduct(int prodId) {
    String sql="DELETE FROM gaming_db.products WHERE prodId = "+ prodId;  
    return jdbcTemplate.update(sql);
  }
  
  //Updates a product in the database.
  public int updateProduct(Product product) {
    String sql="UPDATE gaming_db.products SET productName=?, productDescription=?, productQuantity=?, productPrice=? WHERE prodId = "+ product.getProdId();  
    return jdbcTemplate.update(sql, product.getProductName(), product.getProductDescription(),product.getProductQuantity(),product.getProductPrice());
  }
  
}

//use the RowMapper implementation to iterate the ResultSet and add it into the collection.
class ProductMapper implements RowMapper<Product> {
  public Product mapRow(ResultSet rs, int arg1) throws SQLException {
    Product product = new Product();
    product.setProdId(rs.getInt("prodId"));
    product.setProductName(rs.getString("productName"));
    product.setProductDescription(rs.getString("productDescription"));
    product.setProductQuantity(rs.getInt("productQuantity"));
    product.setProductPrice(rs.getDouble("productPrice"));
    return product;
  }
}
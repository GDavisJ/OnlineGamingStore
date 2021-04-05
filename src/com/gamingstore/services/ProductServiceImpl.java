package com.gamingstore.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gamingstore.dao.ProductDao;
import com.gamingstore.models.Product;

/**Product service used to handle the flow of information between the controller and DAO.*/
public class ProductServiceImpl implements ProductService {
	/**Inject the product DAO.*/
	@Autowired
	public ProductDao productDao;
	private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	/**Used to add a product to the database.*/
	public int registerProduct(Product product) {
		logger.info("Entering and Leaving ProductService.registerProduct");
		return productDao.registerProduct(product);
	}


	/**Used to verify if the product name already exists within the database.*/
	public boolean checkProduct(Product product) {
		logger.info("Entering and Leaving ProductService.checkProduct");
		return productDao.checkProduct(product);
	}


	/**Used to get all the products from the database and return a list of products.*/
	public List<Product> getProducts() {
		logger.info("Entering and Leaving ProductService.getProducts");
		return productDao.getProducts();
	}

	/**Used to delete a product.*/
	@Override
	public int deleteProduct(int prodId) {
		logger.info("Entering and Leaving ProductService.deleteProduct");
		return productDao.deleteProduct(prodId);
	}

	/**Used to get a product when an update is needed.*/
	@Override
	public Product getProduct(int prodId) {
		logger.info("Entering and Leaving ProductService.getProduct");
		return productDao.getProduct(prodId);
	}

	/**Used to update a product.*/
	@Override
	public int updateProduct(Product product) {
		logger.info("Entering and Leaving ProductService.updateProduct");
		return productDao.updateProduct(product);
	}

}

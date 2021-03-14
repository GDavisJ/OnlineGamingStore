package com.gamingstore.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gamingstore.models.Product;
import com.gamingstore.services.ProductService;

@Controller
public class ProductController {
	//inject the Product service
	@Autowired
	public ProductService productService;
	
	//used to GET the add product page based on user request
	@RequestMapping(path = "/addproduct", method = RequestMethod.GET) 
	public ModelAndView displayForm() {
		return new ModelAndView("addProduct", "product", new Product());
	}
	
	//method is called once the add product form is submitted (POST).
	@RequestMapping(path = "/addproduct", method = RequestMethod.POST)
	public ModelAndView addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {

		//verify the form doesn't have errors and if it does, return to add product page with errors.
		if (result.hasErrors()) {
			return new ModelAndView("addProduct", "product", product);
		}
		
		//No form errors found.
		else {
			//Verify if this is a new product or not.
			if(product.getProdId() != null) {
				productService.updateProduct(product); //Update the product in the db
			}else {
				/*verify the product name doesn't already exist and if it doesn't add the product to the db, 
				 * else return an error notifying the user.
				 */
				boolean check = productService.checkProduct(product);
				if(check == false)
				{
					productService.registerProduct(product);
				}
				else
				{
					  result.rejectValue("productName", "error.product", "The product already exists");
					  return new ModelAndView("addProduct", "product", product);
				}
			}
			
			return new ModelAndView("displayProducts", "products", productService.getProducts());
		}
		
	}
	
	
	//used to update a product
	@GetMapping(path = "/updateProd") 
	public ModelAndView updateProduct(@RequestParam("prodId") int prodId) {
		Product product = productService.getProduct(prodId);
		return new ModelAndView("addProduct", "product", product);
	}
	
	//used to delete a product
	@GetMapping(path = "/deleteProd") 
	public ModelAndView deleteProduct(@RequestParam("prodId") int prodId) {
		productService.deleteProduct(prodId);
		return new ModelAndView("displayProducts", "products", productService.getProducts());
	}
	
	//used to GET the add products page
	@RequestMapping(path = "/getProducts", method = RequestMethod.GET) 
	public ModelAndView displayProducts() {
		return new ModelAndView("displayProducts", "products", productService.getProducts());
	}
	
}

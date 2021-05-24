package com.sadi.asm2.controller.Production;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Production.Product;
import com.sadi.asm2.service.Production.ProductService;

@RestController
@RequestMapping(path="products")
public class ProductController {
	@Autowired
	private ProductService productService; 

	@RequestMapping(path = "" , method = RequestMethod.POST )
	public Product createProduct(@RequestBody Product product) {
		return this.productService.createProduct(product);
	}

	@RequestMapping(path = "", method = { RequestMethod.GET })
	public List<Product> getAllProducts() {
		return this.productService.getAllProducts();
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public Product getProduct(@PathVariable int id) {
		return this.productService.getProduct(id);
	}
	
	@RequestMapping(value="/{id}", method = { RequestMethod.PUT })
	public void updateProduct(@PathVariable int id, @RequestBody Product newProduct) {
		Product currentProduct = this.getProduct(id);
		currentProduct.setBrand(newProduct.getBrand());
		currentProduct.setCategory(newProduct.getCategory());
		currentProduct.setCompany(newProduct.getCompany());
		currentProduct.setDescription(newProduct.getDescription());
		currentProduct.setModel(newProduct.getModel());
		currentProduct.setName(newProduct.getName());
		currentProduct.setPrice(newProduct.getPrice());
		this.productService.updateProduct(currentProduct);
	}

	@RequestMapping(value =  "/{id}", method = { RequestMethod.DELETE })
	public void deleteProduct(@PathVariable int id) {
		this.productService.deleteProduct(id);
	}

	
	@RequestMapping(path = "/search", method = { RequestMethod.POST })
	public List<Product> searchProduct(@RequestBody Product product) {
		return this.productService.searchProduct(product);

	}
	
	@RequestMapping(path = "/page", method = { RequestMethod.GET })
	public List<Product> getAllPaginatedProduct(@RequestParam int startRecord, @RequestParam int maxRecords) {
		return this.productService.getAllPaginatedProduct(startRecord, maxRecords);
	}
}

package com.sadi.asm2.controller.Production;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sadi.asm2.model.Production.Category;
import com.sadi.asm2.service.Production.CategoryService;

@RestController
@RequestMapping(path="categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(path = "" , method = RequestMethod.POST )
	public Category createCategory(@RequestBody Category category) {
		return this.categoryService.createCategory(category);
	}

	@RequestMapping(path = "", method = { RequestMethod.GET })
	public List<Category> getAllCategories() {
		return this.categoryService.getAllCategories();
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	public Category getProduct(@PathVariable int id) {
		return this.categoryService.getCategory(id);
	}
	
	@RequestMapping(value="/{id}", method = { RequestMethod.PUT })
	public void updateProduct(@PathVariable int id, @RequestBody Category newCategory) {
		Category currentCategory = this.getProduct(id);	
		currentCategory.setName(newCategory.getName());
		this.categoryService.updateCategory(currentCategory);
	}

	@RequestMapping(value =  "/{id}", method = { RequestMethod.DELETE })
	public void deleteCategory(@PathVariable int id) {
		this.categoryService.deleteCategory(id);
	}

	
	@RequestMapping(path = "/search", method = { RequestMethod.POST })
	public List<Category> searchProduct(@RequestBody Category category) {
		return this.categoryService.searchCategory(category);

	}
	
	@RequestMapping(path = "/page", method = { RequestMethod.GET })
	public List<Category> getAllPaginatedCategory(@RequestParam int startRecord, @RequestParam int maxRecords) {
		return this.categoryService.getAllPaginatedCategories(startRecord, maxRecords);
	}
}

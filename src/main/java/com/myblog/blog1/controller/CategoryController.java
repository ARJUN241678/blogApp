package com.myblog.blog1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myblog.blog1.payload.ApiResponse;
import com.myblog.blog1.payload.CategoryDto; 
import com.myblog.blog1.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@Valid@RequestBody CategoryDto categoryDto)	
	{
		CategoryDto createDto=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createDto,HttpStatus.CREATED);
	}
		
		
		
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto>getCategory(@PathVariable Integer id)	
	{
				
			return  ResponseEntity.ok(this.categoryService.getCategoryById(id));	
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>>getCategory()	
	{
				List<CategoryDto> list=this.categoryService.getAllCategory();
			return  ResponseEntity.ok(list)	;
	}
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto>updateCategory(@Valid@RequestBody CategoryDto categoryDto ,@PathVariable Integer id)	
	{
		CategoryDto updateCategoryDto=this.categoryService.updateCategory(categoryDto,id);
			return  ResponseEntity.ok(updateCategoryDto);	
	}
		

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer id) {
	    this.categoryService.deleteCategory(id);
	    return new ResponseEntity(new ApiResponse("User deleted sucessfully",false),HttpStatus.OK);

	}

}

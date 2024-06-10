package com.myblog.blog1.service;

import java.util.List;

import com.myblog.blog1.payload.CategoryDto;


public interface CategoryService {
	 CategoryDto createCategory (CategoryDto  category);
	 CategoryDto updateCategory (CategoryDto category,Integer id);
	 CategoryDto getCategoryById (Integer id);
		List<CategoryDto> getAllCategory();
	void deleteCategory(Integer id);
}

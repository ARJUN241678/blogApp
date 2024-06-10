package com.myblog.blog1.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.blog1.entity.Category;
import com.myblog.blog1.exception.ResourceNotFoundException;
import com.myblog.blog1.payload.CategoryDto;
import com.myblog.blog1.repository.CategoryRepo;
import com.myblog.blog1.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryRepo categoryRepo;
@Autowired
	private ModelMapper modelMapper;
	@Override
	public CategoryDto createCategory(CategoryDto category) {
	Category cat=	this.modelMapper.map(category,Category.class);
		Category savedCat=this.categoryRepo.save(cat);
		return this.modelMapper.map(savedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto category, Integer id) {

		Category cat = this.categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		
		cat.setCategoryId(category.getCategoryId());
		cat.setCategoryDescription(category.getCategoryDescription());
		cat.setCategoryTitle(category.getCategoryTitle());
	
		Category updatedCategory=this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Category cat = this.categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> cat=this.categoryRepo.findAll();
		
		List<CategoryDto> categoryDto=cat.stream().map(cats->this.modelMapper.map(cats,CategoryDto.class)).collect(Collectors.toList());
		return categoryDto;
	}

	@Override
	public void deleteCategory(Integer id) {
		Category cat = this.categoryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		this.categoryRepo.delete(cat);
	}
	
	

}

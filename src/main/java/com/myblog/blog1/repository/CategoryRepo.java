package com.myblog.blog1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.blog1.entity.Category;


public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

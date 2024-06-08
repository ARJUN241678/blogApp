package com.myblog.blog1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myblog.blog1.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}

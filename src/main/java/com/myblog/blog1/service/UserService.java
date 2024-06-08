package com.myblog.blog1.service;

import java.util.List;

import com.myblog.blog1.payload.UserDto;

public interface UserService {
  
	
	 UserDto createUser (UserDto user);
	 UserDto updateUser (UserDto user,Integer id);
	 UserDto getUserById (Integer id);
		List<UserDto> getAllUsers();
	void deleteUser(Integer id);
}

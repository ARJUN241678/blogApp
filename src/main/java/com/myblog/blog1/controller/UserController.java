package com.myblog.blog1.controller;

import java.util.Map;

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
import com.myblog.blog1.payload.UserDto;
import com.myblog.blog1.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//POST create user
	@PostMapping("/")
public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto)	
{
	UserDto CreatuserDto=this.userService.createUser(userDto);
	return new ResponseEntity<>(CreatuserDto,HttpStatus.CREATED);
}
	
	
	
@GetMapping("/{id}")
public ResponseEntity<UserDto>getUser(@PathVariable Integer id)	
{
			
		return  ResponseEntity.ok(this.userService.getUserById(id));	
}
@PutMapping("/{id}")
public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto ,@PathVariable Integer id)	
{
	UserDto updateuserDto=this.userService.updateUser(userDto,id);
		return  ResponseEntity.ok(updateuserDto);	
}
	

@DeleteMapping("/{id}")
public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer id) {
    this.userService.deleteUser(id);
    return new ResponseEntity(new ApiResponse("User deleted sucessfully",false),HttpStatus.OK);

}
}

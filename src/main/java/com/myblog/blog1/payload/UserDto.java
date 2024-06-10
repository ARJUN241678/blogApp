package com.myblog.blog1.payload;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
@NotEmpty
@Size(min = 4,message = "username must be minimum 4 characters")
	private String name;
@Email(message = "Email not valid")
	private String email;
@NotEmpty
@Size(min=5,message="password must contain min 5 chars")
	private String password;

@NotEmpty
	private String about;
}

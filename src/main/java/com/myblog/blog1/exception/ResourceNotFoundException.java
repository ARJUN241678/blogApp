package com.myblog.blog1.exception;

public class ResourceNotFoundException  extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long value;
	public ResourceNotFoundException(String resourceName, String fieldName, long value) {
		super(String.format("%s not found %s : %s", resourceName,fieldName,value));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.value = value;
	}
	
	

}

package com.example.demo;

public class UserDto {

	Long Long;
	String name;
	public Long getLong() {
		return Long;
	}
	public void setLong(Long l) {
		Long = l;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserDto(java.lang.Long l, String name) {
		super();
		Long = l;
		this.name = name;
	}
	
	
}

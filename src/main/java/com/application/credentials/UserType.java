package com.application.credentials;

public enum UserType {

	SIMPLE_USER("Simple User"),
	ADMIN("Admin");
	
	private String name; 
	
	private UserType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public UserType getUserTypeByName(String name){
		for(UserType type : UserType.values()){
			if(type.getName() == name){
				return type;
			}
		}
		return null;
	}
}

package com.application.database;

import java.util.List;

import com.application.credentials.User;

public interface BaseImplementation {
	
	<T extends BaseEntity> void  add(T entity);

	<T extends BaseEntity> T update(T entity);

	public User getUserByUserName(String name);
	//void flush();

	<T extends BaseEntity> List<T> getAll();
	
}

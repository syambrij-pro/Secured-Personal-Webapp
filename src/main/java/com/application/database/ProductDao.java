package com.application.database;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProductDao {
	
	 void  add(Product entity);

	 Product update(Product entity);

	<T> List<T> getAll();
}

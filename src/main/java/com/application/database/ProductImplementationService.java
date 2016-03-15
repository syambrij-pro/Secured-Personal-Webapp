package com.application.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
public class ProductImplementationService implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void add(Product entity) {
		Product p = (Product) entity;
		entityManager.persist(p);
	}

	@Override
	//@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> getAll() {
		List<Product> result = entityManager.createQuery(" FROM Product", Product.class).getResultList();
	    return result;
	}

	@Override
	public Product update(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

}

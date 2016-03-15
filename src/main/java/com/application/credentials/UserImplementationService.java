package com.application.credentials;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.application.credentials.User;
import com.application.database.BaseEntity;
import com.application.database.BaseImplementation;

@Service
public class UserImplementationService {
	
	  @PersistenceContext
	  private EntityManager em;
	   
	  // Since we've setup <tx:annotation-config> and transaction manager on spring-context.xml,
	  // any bean method annotated with @Transactional will cause Spring to magically call
	  // begin() and commit() at the start/end of the method. If exception occurs it will also
	  // call rollback()
	  @Transactional
	  public List<User> getAll() {
	    List<User> result = em.createQuery("SELECT u FROM User u", User.class).getResultList();
	    return result;
	  }
	  
	  @Transactional
	  public User getUserByUserName(String name){
		  Query query = em.createQuery("select u from User u where u.username=:name" , User.class);
		  query.setParameter("name",name);
		  User user = (User)query.getSingleResult();
		  return user;
	  }
	  
	public <T extends BaseEntity> T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public <T extends BaseEntity> void add(T entity) {
	    em.persist(entity);		
	}

	/*public void flush() {
		
	}*/
}

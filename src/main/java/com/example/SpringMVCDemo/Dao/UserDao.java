package com.example.SpringMVCDemo.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SpringMVCDemo.model.User;

@Component
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public List<User> getUsers(){
		
		
		Session session= sessionFactory.getCurrentSession();
		List<User> users=session.createQuery("from User" , User.class).list();
		return users;
	}

	@Transactional
	public void addUser(User user) {
		
		Session session= sessionFactory.getCurrentSession();
		session.save(user);
	}
	@Transactional
	public User getUser(int uid) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		User user=session.get(User.class , uid);
		return user;
	}
}

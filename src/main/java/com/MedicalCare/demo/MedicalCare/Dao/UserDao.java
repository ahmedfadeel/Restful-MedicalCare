package com.MedicalCare.demo.MedicalCare.Dao;

import com.MedicalCare.demo.MedicalCare.Entities.User;

public interface UserDao {
	
	public long addUser(User user);
	public void updateUser(User user);
	public User getUser(String userName, String password);
	public User getUserById(long id) ;
	public User getUserByUsername(String userName);

	

}

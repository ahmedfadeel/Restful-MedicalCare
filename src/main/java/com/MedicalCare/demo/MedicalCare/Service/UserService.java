package com.MedicalCare.demo.MedicalCare.Service;

import java.util.Set;

import com.MedicalCare.demo.MedicalCare.Entities.User;
import com.MedicalCare.demo.MedicalCare.Entities.security.UserRole;

public interface UserService {


	public long addUser(User user);
	public void updateUser(User user);
	public User getUser(String userName, String password);
	public User getUserById(long id) ;
	
	public User getUserByUserName(String userName);
	
	public long createUser(User user , Set<UserRole> userRoles);

}

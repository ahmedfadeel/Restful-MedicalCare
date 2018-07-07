package com.MedicalCare.demo.MedicalCare.ServiceImpl;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedicalCare.demo.MedicalCare.Dao.RoleDao;
import com.MedicalCare.demo.MedicalCare.Dao.UserDao;
import com.MedicalCare.demo.MedicalCare.Entities.User;
import com.MedicalCare.demo.MedicalCare.Entities.security.Role;
import com.MedicalCare.demo.MedicalCare.Entities.security.UserRole;
import com.MedicalCare.demo.MedicalCare.Service.UserService;

@Service
public class UserServiceImp implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	
	@Override
	public long addUser(User user) {
		return userDao.addUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public User getUser(String userName, String password) {
		return userDao.getUser(userName, password);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(userName);
	}

	@Override
	public long createUser(User user, Set<UserRole> userRoles) {
		User localUser = userDao.getUserByUsername(user.getUsername());
		long id = 0;
		if(localUser!=null) {
			LOG.info("User with this unerName is already exists , nothing will be done. ",user.getUsername());
		}else {
			for (UserRole ur : userRoles) {
				roleDao.addRole(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			id = userDao.addUser(user);
		}
		
		
		return id;
	}
}

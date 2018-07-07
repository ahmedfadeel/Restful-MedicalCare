package com.MedicalCare.demo.MedicalCare;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MedicalCare.demo.MedicalCare.Entities.User;
import com.MedicalCare.demo.MedicalCare.Entities.security.Role;
import com.MedicalCare.demo.MedicalCare.Entities.security.UserRole;
import com.MedicalCare.demo.MedicalCare.Service.UserService;
import com.MedicalCare.demo.MedicalCare.config.SecurityUtility;

@SpringBootApplication
public class MedicalCareApplication implements CommandLineRunner {
	
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(MedicalCareApplication.class, args);
		System.out.println("done");		
	}

	@Override
	public void run(String... arg0) throws Exception {
		User user1 = new User();
		user1.setUsername("mostafa");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("elabbasy"));
		user1.setTybe("receptionist");
		
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		//role1.setRoleId(1);
		role1.setName("ROLE_USER");
		
		userRoles.add(new UserRole(user1,role1));
		
		userService.createUser(user1, userRoles);
		
		
	}

	
}

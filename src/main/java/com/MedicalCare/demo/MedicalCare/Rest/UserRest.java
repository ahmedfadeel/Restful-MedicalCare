package com.MedicalCare.demo.MedicalCare.Rest;

import java.net.URI;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MedicalCare.demo.MedicalCare.Entities.User;
import com.MedicalCare.demo.MedicalCare.Entities.security.Role;
import com.MedicalCare.demo.MedicalCare.Entities.security.UserRole;
import com.MedicalCare.demo.MedicalCare.Service.UserService;
import com.MedicalCare.demo.MedicalCare.config.SecurityUtility;

@RestController
@RequestMapping("/user")
public class UserRest {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		
		if(userService.getUserByUserName(user.getUsername()) != null) {
			return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
		}
		String password = user.getPassword();
		String encreptedPss = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(password);
		Role role = new Role();
		if(user.getTybe().equals("patient")) {
			role.setRoleId(1);
		}else if(user.getTybe().equals("doctor")) {
			role.setRoleId(2);
		}else if(user.getTybe().equals("hospital")) {
			role.setRoleId(3);
		}
		role.setName(user.getTybe());
		
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));
		
		long id =userService.addUser(user);
		if(id!=0) {
			return new ResponseEntity("User Added Successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
		}
		
	}
	@RequestMapping("/getCurrentUser")
	public User getCurrentUser(Principal principal) {
		User user = new User();
		if (null != principal) {
			user = userService.getUserByUserName(principal.getName());
		}

		return user;
	}
	@RequestMapping(value = "/userName/{userName}/pass/{password}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> getUser(@PathVariable String userName,@PathVariable String password) {
		User user = userService.getUser(userName, password);
		if(user==null) {
			return new ResponseEntity<String>("users Not Found !!",
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity <User>(user, HttpStatus.OK);

		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable long id){
		User user = userService.getUserById(id);
		
		if(user==null) {
			return new ResponseEntity<String>("users Not Found !!",
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity <User>(user, HttpStatus.OK);

		}
			
		
	}
}

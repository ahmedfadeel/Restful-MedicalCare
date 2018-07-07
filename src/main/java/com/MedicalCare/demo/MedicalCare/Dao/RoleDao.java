package com.MedicalCare.demo.MedicalCare.Dao;

import java.util.List;

import com.MedicalCare.demo.MedicalCare.Entities.security.Role;

public interface RoleDao {
	
	public void addRole(Role role);
	public List<Role> getAll();

}

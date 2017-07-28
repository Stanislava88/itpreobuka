package com.iktpreobuka.aplikacija.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.aplikacija.entities.RoleEntity;
import com.iktpreobuka.aplikacija.repositories.RoleRepository;

@RestController
@RequestMapping(path="/role")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(path = "/all", method=RequestMethod.GET)
	public Iterable<RoleEntity> getRoles() {
		try {
			return roleRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}

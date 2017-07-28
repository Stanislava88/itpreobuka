package com.iktpreobuka.aplikacija.services;

import com.iktpreobuka.aplikacija.entities.ClientEntity;

public interface ClientDAO {
	
	public ClientEntity findClientByID(Integer id);
	
	public ClientEntity findClientByEmail(String email);
	
}

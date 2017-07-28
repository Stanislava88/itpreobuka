package com.iktpreobuka.aplikacija.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.aplikacija.dtos.ClientWithPasswordDTO;
import com.iktpreobuka.aplikacija.dtos.LoginDTO;
import com.iktpreobuka.aplikacija.entities.ClientEntity;
import com.iktpreobuka.aplikacija.repositories.ClientRepository;
import com.iktpreobuka.aplikacija.services.ClientDAO;
import com.iktpreobuka.aplikacija.services.RoleDAO;

@RestController
@RequestMapping(path="/client")
public class ClientController {
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@RequestMapping(path = "/login", 
					method = RequestMethod.POST)
	public Integer login(@RequestBody LoginDTO loginDTO) {
		try {
			ClientEntity client = clientDAO.findClientByEmail(loginDTO.getEmail());
			if(client == null)
				return -1;
			
			if(client.getPassword().equals(loginDTO.getPassword()))
				return client.getId();
			
			return -1;
		} catch (Exception e) {
			return -1;
		}
	}
	
	@RequestMapping(path = "/{id}", 
			method = RequestMethod.GET)
	public ClientEntity getClient(@PathVariable String id) {
		try {
			return clientDAO.findClientByID(Integer.parseInt(id));
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@RequestMapping(path = "/all", 
			method = RequestMethod.GET)
	public Iterable<ClientEntity> getClients() {
		try {
			return clientRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(path="/isadmin/{id}")
	public boolean isAdmin(@PathVariable String id) {
		try {
			ClientEntity client = clientDAO.findClientByID(Integer.parseInt(id));
			if (client == null) return false;
			if ("admin".equals(client.getRoleEntity().getType())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	@RequestMapping(path = "/register", 
			method = RequestMethod.POST)
	public boolean register(@RequestBody ClientWithPasswordDTO clientWithPasswordDTO) {
		try {
			System.out.println("register");
			ClientEntity client = clientDAO.findClientByEmail(clientWithPasswordDTO.getEmail());
			if(client != null)
				return false;
			
			ClientEntity clientEntity = new ClientEntity();
			clientEntity.setName(clientWithPasswordDTO.getName());
			clientEntity.setSurname(clientWithPasswordDTO.getSurname());
			clientEntity.setEmail(clientWithPasswordDTO.getEmail());
			clientEntity.setPassword(clientWithPasswordDTO.getPassword());
			System.out.println(clientWithPasswordDTO.getRoleID());
			clientEntity.setRoleEntity(roleDAO.findRoleByID(clientWithPasswordDTO.getRoleID()));
			
			clientRepository.save(clientEntity);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}

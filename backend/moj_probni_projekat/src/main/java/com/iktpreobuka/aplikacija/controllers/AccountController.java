package com.iktpreobuka.aplikacija.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.aplikacija.entities.AccountEntity;
import com.iktpreobuka.aplikacija.entities.ClientEntity;
import com.iktpreobuka.aplikacija.repositories.AccountRepository;
import com.iktpreobuka.aplikacija.services.AccountDAO;
import com.iktpreobuka.aplikacija.services.ClientDAO;

@RestController
@RequestMapping(path="/accounts")
public class AccountController {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(path="/all",method=RequestMethod.GET)
	public Iterable<AccountEntity> getAllAccounts() {
		try {
			return accountRepository.findAll();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.GET)
	public Iterable<AccountEntity> getAccounts(@PathVariable String id) {
		System.out.println(id);
		try {
			ClientEntity client = clientDAO.findClientByID(Integer.parseInt(id));
			if (client == null) return null;
			if ("admin".equals(client.getRoleEntity().getType())) {
				return accountRepository.findAll();
			} else {
				return accountDAO.findAccountsByClientID(Integer.parseInt(id));
			}
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@RequestMapping(path="/others/{id}",method=RequestMethod.GET)
	public Iterable<AccountEntity> getOtherAccounts(@PathVariable String id) {
		System.out.println(id);
		try {
			ClientEntity client = clientDAO.findClientByID(Integer.parseInt(id));
			if (client == null) return null;
			if ("admin".equals(client.getRoleEntity().getType())) {
				return accountRepository.findAll();
			} else {
				return accountDAO.findOtherAccountsByClientID(Integer.parseInt(id));
			}
			
		} catch (Exception e) {
			return null;
		}
		
	}

}

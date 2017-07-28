package com.iktpreobuka.aplikacija.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.aplikacija.entities.BankEntity;
import com.iktpreobuka.aplikacija.entities.ClientEntity;
import com.iktpreobuka.aplikacija.repositories.BankRepository;
import com.iktpreobuka.aplikacija.services.BankDAO;
import com.iktpreobuka.aplikacija.services.ClientDAO;

@RestController
@RequestMapping(path = "/banks")
public class BankController {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Autowired
	private BankDAO bankDAO;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@RequestMapping(path = "/all/{id}", method = RequestMethod.GET)
	public Iterable<BankEntity> getAll(@PathVariable String id) {
		try {
			ClientEntity client = clientDAO.findClientByID(Integer.parseInt(id));
			if (client == null) return null;
			if ("admin".equals(client.getRoleEntity().getType())) {
				System.out.println(client.getName());
				return bankRepository.findAll();
			} else {
				return bankDAO.findBanksByClientID(Integer.parseInt(id));
			}
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean addBank(@RequestBody BankEntity bank) {
		try {
			BankEntity bankEntity = new BankEntity();
			bankEntity.setName(bank.getName());
			bankEntity.setPIB(Integer.toString(new Random().nextInt(999999999)));
			bankEntity.setNBSnumber(Integer.toString(new Random().nextInt(999999999)));
			bankRepository.save(bankEntity);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean deleteBank(@RequestBody BankEntity bank) {
		try {
			bankRepository.delete(bank.getID());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

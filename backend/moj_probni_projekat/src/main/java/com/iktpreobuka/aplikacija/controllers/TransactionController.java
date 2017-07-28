package com.iktpreobuka.aplikacija.controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.aplikacija.dtos.TransactionDTO;
import com.iktpreobuka.aplikacija.entities.AccountEntity;
import com.iktpreobuka.aplikacija.entities.ClientEntity;
import com.iktpreobuka.aplikacija.entities.TransactionEntity;
import com.iktpreobuka.aplikacija.repositories.AccountRepository;
import com.iktpreobuka.aplikacija.repositories.TransactionRepository;
import com.iktpreobuka.aplikacija.services.AccountDAO;
import com.iktpreobuka.aplikacija.services.ClientDAO;
import com.iktpreobuka.aplikacija.services.CurrencyDAO;
import com.iktpreobuka.aplikacija.services.TransactionDAO;

@RestController
@RequestMapping(path="/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CurrencyDAO currencyDAO;
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public boolean addTransaction(@RequestBody TransactionDTO transactionDTO){
		try {
			System.out.println("addTransaction: "+transactionDTO.getAmount());
			TransactionEntity transactionEntity = new TransactionEntity();
			
			AccountEntity senderAcc = accountDAO.findAccountByAccountNumber(Long.parseLong(transactionDTO.getSenderAccount()));
			AccountEntity receiverAcc = accountDAO.findAccountByAccountNumber(Long.parseLong(transactionDTO.getReceiverAccount()));
			
			if (senderAcc.getBalance() < Double.parseDouble(transactionDTO.getAmount())) {
				return false;
			}
			
			senderAcc.setBalance(senderAcc.getBalance() - Double.parseDouble(transactionDTO.getAmount()));
			receiverAcc.setBalance(receiverAcc.getBalance() + Double.parseDouble(transactionDTO.getAmount()));
			
			accountRepository.save(senderAcc);
			accountRepository.save(receiverAcc);
			
			transactionEntity.setSender(senderAcc);
			transactionEntity.setReceiver(receiverAcc);	
			transactionEntity.setLocalDate(new Date(System.currentTimeMillis()));
			transactionEntity.setPurpose(transactionDTO.getReason());
			transactionEntity.setAmmount(Double.parseDouble(transactionDTO.getAmount()));
			transactionEntity.setCurrency(currencyDAO.findCurrencyByName(transactionDTO.getCurrency()));
			
			transactionRepository.save(transactionEntity);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Iterable<TransactionEntity> getTransactions(@PathVariable String id){
		System.out.println("getTransaction");
		try {
			ClientEntity client = clientDAO.findClientByID(Integer.parseInt(id));
			if (client == null) return null;
			if ("admin".equals(client.getRoleEntity().getType())) {
				return transactionRepository.findAll();
			} else {
				return transactionDAO.getTransactions(Integer.parseInt(id));
			}
		} catch (Exception e) {
			return null;
		}
	}
	
}
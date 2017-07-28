package com.iktpreobuka.aplikacija.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.aplikacija.entities.AccountEntity;
import com.iktpreobuka.aplikacija.entities.BankEntity;

@Service
public class BankDAOImpl implements BankDAO {

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public List<BankEntity> findBanksByClientID(Integer id) {
		List<AccountEntity> accountEntities = accountDAO.findAccountsByClientID(id);
		List<BankEntity> bankEntities = new ArrayList<>();
		for (AccountEntity acc : accountEntities) {
			if (acc != null)
				bankEntities.add(acc.getBank());
		}
		return bankEntities;
	}

	
}

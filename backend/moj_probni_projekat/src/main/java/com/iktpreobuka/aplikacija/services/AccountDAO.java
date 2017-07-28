package com.iktpreobuka.aplikacija.services;

import java.util.List;

import com.iktpreobuka.aplikacija.entities.AccountEntity;

public interface AccountDAO {

	public List<AccountEntity> findAccountsByClientID(Integer id);

	public List<AccountEntity> findOtherAccountsByClientID(Integer id);
	
	public AccountEntity findAccountByAccountNumber(Long accountNumber);

}

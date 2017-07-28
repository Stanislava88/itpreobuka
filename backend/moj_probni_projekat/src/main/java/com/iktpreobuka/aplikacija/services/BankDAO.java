package com.iktpreobuka.aplikacija.services;

import java.util.List;

import com.iktpreobuka.aplikacija.entities.BankEntity;

public interface BankDAO {
	public List<BankEntity> findBanksByClientID(Integer id);
}

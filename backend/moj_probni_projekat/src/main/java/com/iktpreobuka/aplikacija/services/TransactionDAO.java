package com.iktpreobuka.aplikacija.services;

import com.iktpreobuka.aplikacija.entities.TransactionEntity;

public interface TransactionDAO {
	
	public Iterable<TransactionEntity> getTransactions(Integer clientID);

	public Iterable<TransactionEntity> getOtherTransactions(Integer clientID);

}

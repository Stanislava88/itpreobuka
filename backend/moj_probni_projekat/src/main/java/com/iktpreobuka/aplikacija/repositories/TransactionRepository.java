package com.iktpreobuka.aplikacija.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.aplikacija.entities.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
	
	

}

package com.iktpreobuka.aplikacija.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.aplikacija.entities.BankEntity;

public interface BankRepository extends CrudRepository<BankEntity, Integer> {

}

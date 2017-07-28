package com.iktpreobuka.aplikacija.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.aplikacija.entities.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

}

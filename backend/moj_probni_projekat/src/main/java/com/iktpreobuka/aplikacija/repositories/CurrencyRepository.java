package com.iktpreobuka.aplikacija.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.aplikacija.entities.CurrencyEntity;

public interface CurrencyRepository extends CrudRepository<CurrencyEntity, String> {

}

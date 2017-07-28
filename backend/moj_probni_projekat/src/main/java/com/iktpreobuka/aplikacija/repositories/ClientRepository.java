package com.iktpreobuka.aplikacija.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.aplikacija.entities.ClientEntity;

public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

}

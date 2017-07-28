package com.iktpreobuka.aplikacija.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.aplikacija.entities.CurrencyEntity;

@Service
public class CurrencyDAOImpl implements CurrencyDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public CurrencyEntity findCurrencyByName(String name) {
		String sql= "select c "+"from CurrencyEntity c " 
				+"where c.name = :name ";
		Query query= em.createQuery(sql);
		query.setParameter("name", name);
		return (CurrencyEntity) query.getSingleResult();
	}

}

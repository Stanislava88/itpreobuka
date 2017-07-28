package com.iktpreobuka.aplikacija.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iktpreobuka.aplikacija.entities.AccountEntity;
import com.iktpreobuka.aplikacija.entities.ClientEntity;

@Service
public class AccountDAOImpl implements AccountDAO {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	public List<AccountEntity> findAccountsByClientID(Integer id) {
		String sql= "select a "+"from AccountEntity a " 
				+"where a.client.id = :clientid ";
		Query query= em.createQuery(sql);
		query.setParameter("clientid", id);
		return query.getResultList();
	}

	@Override
	public List<AccountEntity> findOtherAccountsByClientID(Integer id) {
		String sql= "select a "+"from AccountEntity a " 
				+"where a.client.id != :clientid ";
		Query query= em.createQuery(sql);
		query.setParameter("clientid", id);
		return query.getResultList();
	}

	@Override
	public AccountEntity findAccountByAccountNumber(Long accountNumber) {
		String sql= "select a "+"from AccountEntity a " 
				+"where a.accountNumber = :accountNumber ";
		Query query= em.createQuery(sql);
		query.setParameter("accountNumber", accountNumber);
		return (AccountEntity) query.getSingleResult();
	}
	
	
	


}

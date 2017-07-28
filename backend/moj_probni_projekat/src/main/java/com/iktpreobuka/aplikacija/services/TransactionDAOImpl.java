package com.iktpreobuka.aplikacija.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.aplikacija.entities.TransactionEntity;

@Service
public class TransactionDAOImpl implements TransactionDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Iterable<TransactionEntity> getTransactions(Integer clientID) {
		String sql= "select t "+"from TransactionEntity t " 
				+"where t.sender.id = :senderID or t.receiver.id = :receiverID";
		Query query= em.createQuery(sql);
		query.setParameter("senderID", clientID);
		query.setParameter("receiverID", clientID);
		return query.getResultList();
		
	}

	@Override
	public Iterable<TransactionEntity> getOtherTransactions(Integer clientID) {
		String sql= "select t "+"from TransactionEntity t " 
				+"where t.sender.id != :senderID and t.receiver.id != :receiverID";
		Query query= em.createQuery(sql);
		query.setParameter("senderID", clientID);
		query.setParameter("receiverID", clientID);
		return query.getResultList();
	}

}

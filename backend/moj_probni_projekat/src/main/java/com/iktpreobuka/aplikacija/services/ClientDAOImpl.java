package com.iktpreobuka.aplikacija.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.aplikacija.entities.ClientEntity;

@Service
public class ClientDAOImpl implements ClientDAO {
	
	@PersistenceContext
	EntityManager em;
		
	@Override
	public ClientEntity findClientByEmail(String email) {
		try{
			String sql= "select c "+"from ClientEntity c " 
					+"where c.email = :email";
			Query query= em.createQuery(sql);
			query.setParameter("email", email);
			return (ClientEntity) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}



	@Override
	public ClientEntity findClientByID(Integer id) {
		String sql= "select c "+"from ClientEntity c " 
				+"where c.id = :id";
		Query query= em.createQuery(sql);
		query.setParameter("id", id);
		return (ClientEntity) query.getSingleResult();
	}
}


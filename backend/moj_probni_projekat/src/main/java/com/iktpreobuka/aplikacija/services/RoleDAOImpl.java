package com.iktpreobuka.aplikacija.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.iktpreobuka.aplikacija.entities.RoleEntity;

@Service
public class RoleDAOImpl implements RoleDAO{
	
	@PersistenceContext
	EntityManager em;
		
	@Override
	public RoleEntity findRoleByID(Integer id) {
		String sql= "select r "+"from RoleEntity r " 
				+"where r.ID = :id";
		Query query= em.createQuery(sql);
		query.setParameter("id", id);
		return (RoleEntity) query.getSingleResult();
	}


}

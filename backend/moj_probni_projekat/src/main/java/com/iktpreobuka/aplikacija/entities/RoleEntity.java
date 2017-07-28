package com.iktpreobuka.aplikacija.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Entity
@Table(name="roles")
public class RoleEntity {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer ID;
	@Column(name="type")
	private String type;
	
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	


}

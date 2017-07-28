package com.iktpreobuka.aplikacija.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="Clients")
public class ClientEntity{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="email")
	private String email;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@JsonIgnore
	@ManyToMany(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinTable(name ="Client_Address",joinColumns ={
		@JoinColumn(name ="clientId",nullable =false,updatable =false)},
		inverseJoinColumns ={@JoinColumn(name ="addressID",nullable =false,updatable =false)})
	private Set<AddressEntity> addresses =new HashSet<AddressEntity>();
	
	@JsonIgnore
	@ManyToOne(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinColumn(name="role")
	private RoleEntity roleEntity;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ClientEntity() {
		super();
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}
	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}
	

	
	
}

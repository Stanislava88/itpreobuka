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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Entity
@Table(name="Address")
public class AddressEntity {
	@Id
	@GeneratedValue
	@Column(name="ID")
    private Integer ID;
	@Column(name="street_number")
	private String streetNumber;
	@Column(name="street_name")
	private String streetName;
	@Column(name="unit_number")
	private Integer unitNumber;
	@ManyToMany(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinTable(name ="Bank_Address",joinColumns ={
		@JoinColumn(name ="addressID",nullable =false,updatable =false)},
		inverseJoinColumns ={@JoinColumn(name ="bankID",nullable =false,updatable =false)})
	private Set<BankEntity> banks  =new HashSet<BankEntity>();
	
	@JsonIgnore
	@ManyToMany(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinTable(name ="Client_Address",joinColumns ={
		@JoinColumn(name ="addressID",nullable =false,updatable =false)},
		inverseJoinColumns ={@JoinColumn(name ="clientId",nullable =false,updatable =false)})
	private Set<ClientEntity> clients =new HashSet<ClientEntity>();
	
	
	public AddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Integer getUnitNumber() {
		return unitNumber;
	}


	public void setUnitNumber(Integer unitNumber) {
		this.unitNumber = unitNumber;
	}


	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
}

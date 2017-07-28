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
@Table(name="Banks")
public class BankEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer ID;
	@Column(name="name")
	private String name;
	@Column(name="PIB")
	private String PIB;
	@Column(name="NBS_number")
	private String NBSnumber;
	
	@JsonIgnore
	@ManyToMany(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinTable(name ="Bank_Address",joinColumns ={
		@JoinColumn(name ="bankID",nullable =false,updatable =false)},
		inverseJoinColumns ={@JoinColumn(name ="addressID",nullable =false,updatable =false)})
	private Set<AddressEntity> addresses =new HashSet<AddressEntity>();
    
	
	public BankEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPIB() {
		return PIB;
	}
	public void setPIB(String pIB) {
		PIB = pIB;
	}
	public String getNBSnumber() {
		return NBSnumber;
	}
	public void setNBSnumber(String nBSnumber) {
		NBSnumber = nBSnumber;
	}
	
	

}

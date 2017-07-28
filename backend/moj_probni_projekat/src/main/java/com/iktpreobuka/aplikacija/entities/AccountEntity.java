package com.iktpreobuka.aplikacija.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
@Entity
@Table(name="Accounts")
public class AccountEntity{
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer ID;
	@Column(name="balance")
	private Double balance;
	@Column(name="account_number")
	private Long accountNumber;
	
	@ManyToOne(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinColumn(name="bankID")
	private BankEntity bank;
	
	@ManyToOne(fetch =FetchType.LAZY,cascade =CascadeType.REFRESH)
	@JoinColumn(name="clientID")
	private ClientEntity client;

	
	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public BankEntity getBank() {
		return bank;
	}


	public void setBank(BankEntity bank) {
		this.bank = bank;
	}


	public ClientEntity getClient() {
		return client;
	}


	public void setClient(ClientEntity client) {
		this.client = client;
	}



	
	
	
	

}

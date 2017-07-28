package com.iktpreobuka.aplikacija.entities;

import java.util.Date;

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
@Table(name="Transactions")
public class TransactionEntity {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer ID;
	@Column(name= "date")
	private Date LocalDate;
	@Column(name="ammount")
	private Double ammount;
	@Column(name="purpose")
	private String purpose;
	
    @ManyToOne(cascade =CascadeType.REFRESH,fetch =FetchType.LAZY)
    @JoinColumn(name ="sender")
    private AccountEntity sender;
    
    @ManyToOne(cascade =CascadeType.REFRESH,fetch =FetchType.LAZY)
    @JoinColumn(name ="receiver")
    private AccountEntity receiver;
	
    @ManyToOne(cascade =CascadeType.REFRESH,fetch =FetchType.LAZY)
    @JoinColumn(name ="currency")
    private CurrencyEntity currency;
    
 
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Date getLocalDate() {
		return LocalDate;
	}
	public void setLocalDate(Date localDate) {
		LocalDate = localDate;
	}
	public Double getAmmount() {
		return ammount;
	}
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public AccountEntity getSender() {
		return sender;
	}


	public void setSender(AccountEntity sender) {
		this.sender = sender;
	}


	public AccountEntity getReceiver() {
		return receiver;
	}


	public void setReceiver(AccountEntity receiver) {
		this.receiver = receiver;
	}


	public CurrencyEntity getCurrency() {
		return currency;
	}


	public void setCurrency(CurrencyEntity currency) {
		this.currency = currency;
	}
	
	
	
	
}

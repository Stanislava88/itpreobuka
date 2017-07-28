package com.iktpreobuka.aplikacija.dtos;

public class TransactionDTO {
	
	private String sender;
	private String reason;
	private String receiver;
	private String id;
	private String currency;
	private String amount;
	private String senderAccount;
	private String receiverAccount;
  
	public TransactionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String ammount) {
		this.amount = ammount;
	}
	public String getSenderAccount() {
		return senderAccount;
	}
	public void setSenderAccount(String senderAccount) {
		this.senderAccount = senderAccount;
	}
	public String getReceiverAccount() {
		return receiverAccount;
	}
	public void setReceiverAccount(String receiverAccount) {
		this.receiverAccount = receiverAccount;
	}
}

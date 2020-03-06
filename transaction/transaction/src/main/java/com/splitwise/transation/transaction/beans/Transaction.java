package com.splitwise.transation.transaction.beans;

import java.util.Date;



public class Transaction {
	private int id;
	private int fromUser;
	private int toUser;
	private double amount;
	private Date transactionAt;
	private String description;
	private int groupId;
	private boolean isSettled;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromUser() {
		return fromUser;
	}
	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}
	public int getToUser() {
		return toUser;
	}
	public void setToUser(int toUser) {
		this.toUser = toUser;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTransactionAt() {
		return transactionAt;
	}
	public void setTransactionAt(Date transactionAt) {
		this.transactionAt = transactionAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public boolean isSettled() {
		return isSettled;
	}
	public void setSettled(boolean isSettled) {
		this.isSettled = isSettled;
	}
	public Transaction(int id, int fromUser, int toUser, double amount, Date transactionAt, String description,
			int groupId, boolean isSettled) {
		super();
		this.id = id;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.amount = amount;
		this.transactionAt = transactionAt;
		this.description = description;
		this.groupId = groupId;
		this.isSettled = isSettled;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", fromUser=" + fromUser + ", toUser=" + toUser + ", amount=" + amount
				+ ", transactionAt=" + transactionAt + ", description=" + description + ", groupId=" + groupId
				+ ", isSettled=" + isSettled + "]";
	}
	
	
	
}

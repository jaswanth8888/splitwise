package com.splitwise.transation.transaction.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
	private int id;
	private int fromUser;
	private int toUser;
	private double amount;
	private Date transactionAt;
	private int expenditureId;
	private int groupId;
	private boolean isSettled;
	
}

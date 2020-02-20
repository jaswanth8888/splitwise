package com.example.springbootgroup.beans;

import java.util.List;

public class Group {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreatedById() {
		return createdById;
	}
	public void setCreatedById(int createdById) {
		this.createdById = createdById;
	}
	public List<Integer> getMembers() {
		return members;
	}
	public void setMembers(List<Integer> members) {
		this.members = members;
	}
	public List<Integer> getExpenditures() {
		return expenditures;
	}
	public void setExpenditures(List<Integer> expenditures) {
		this.expenditures = expenditures;
	}
	public Group() {}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", createdById=" + createdById + ", members=" + members
				+ ", expenditures=" + expenditures + ", transactions=" + transactions + "]";
	}
	public List<Integer> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Integer> transactions) {
		this.transactions = transactions;
	}
	private Integer id;
	private String name;
	public Group(Integer id, String name, int createdById, List<Integer> members, List<Integer> expenditures,
			List<Integer> transactions) {
		super();
		this.id = id;
		this.name = name;
		this.createdById = createdById;
		this.members = members;
		this.expenditures = expenditures;
		this.transactions = transactions;
	}
	private int createdById;
	private List<Integer> members;
	private List<Integer> expenditures;
	private List<Integer> transactions;
}


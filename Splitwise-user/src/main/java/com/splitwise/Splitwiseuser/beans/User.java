package com.splitwise.Splitwiseuser.beans;

import java.util.List;

public class User {
	private int id;
	private Name name;
	private String dob;
	private Integer credit;
	private Integer debit;
	private long phoneNumber;
	private String email;
	private String password;
	private Address address;
	private List<Integer> friends;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", credit=" + credit + ", debit=" + debit
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", address="
				+ address + ", friends=" + friends + ", groups=" + groups + "]";
	}
	private List<Integer> groups;
	public User(int id, Name name, String dob, Integer credit, Integer debit, long phoneNumber, String email,
			String password, Address address, List<Integer> friends, List<Integer> groups) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.credit = credit;
		this.debit = debit;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.friends = friends;
		this.groups = groups;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getDebit() {
		return debit;
	}
	public void setDebit(Integer debit) {
		this.debit = debit;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Integer> getFriends() {
		return friends;
	}
	public void setFriends(List<Integer> friends) {
		this.friends = friends;
	}
	public List<Integer> getGroups() {
		return groups;
	}
	public void setGroups(List<Integer> groups) {
		this.groups = groups;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}

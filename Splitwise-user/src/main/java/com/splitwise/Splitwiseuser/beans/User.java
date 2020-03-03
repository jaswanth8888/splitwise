package com.splitwise.Splitwiseuser.beans;
import java.util.List;




public class User {
	private int id;
	private Name name;
	private String dob;
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	private long phoneNumber;
	private String email;
	private Address address;
	private List<Integer> friends;
	private List<Integer> groups;
	public User(int id, Name name, String dob, long phoneNumber, String email, Address address, List<Integer> friends,
			List<Integer> groups) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.friends = friends;
		this.groups = groups;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", address=" + address + ", friends=" + friends + ", groups=" + groups + "]";
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
}

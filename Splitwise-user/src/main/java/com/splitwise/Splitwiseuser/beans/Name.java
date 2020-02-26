package com.splitwise.Splitwiseuser.beans;




public class Name {
	private String firstName;
	private String lastname;
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public Name(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

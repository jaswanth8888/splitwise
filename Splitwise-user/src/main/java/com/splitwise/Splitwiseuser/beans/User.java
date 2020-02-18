package com.splitwise.Splitwiseuser.beans;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
	private int id;
	private Name name;
	private String dob;
	private long phoneNumber;
	private String email;
	private Address address;
	private List<Integer> friends;
	private List<Integer> groups;
}

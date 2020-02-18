package com.splitwise.Splitwiseuser.beans;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
		private String hno;
		private String street;
		private String city;
		private int pincode;
		private String landmark;
		private String state;
		private String country;
		
}
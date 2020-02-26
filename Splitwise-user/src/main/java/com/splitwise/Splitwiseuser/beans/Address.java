package com.splitwise.Splitwiseuser.beans;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Address {
		private String hno;
		private String street;
		private String city;
		private int pincode;
		private String landmark;
		private String state;
		public Address(String hno, String street, String city, int pincode, String landmark, String state,
				String country) {
			super();
			this.hno = hno;
			this.street = street;
			this.city = city;
			this.pincode = pincode;
			this.landmark = landmark;
			this.state = state;
			this.country = country;
		}
		public String getHno() {
			return hno;
		}
		public void setHno(String hno) {
			this.hno = hno;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		public String getLandmark() {
			return landmark;
		}
		public void setLandmark(String landmark) {
			this.landmark = landmark;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		private String country;
		
}
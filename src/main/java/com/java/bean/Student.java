package com.java.bean;
import java.util.Date;

public class Student {

	private int id;
	private String name;
	private String phone_no;
	@Override
	public String toString() {
		return "Student [name=" + name + ", phone_no=" + phone_no + ", email=" + email + ", dob=" + dob + ", education="
				+ education + ", getName()=" + getName() + ", getPhone_no()=" + getPhone_no() + ", getEmail()="
				+ getEmail() + ", getDob()=" + getDob() + ", getEducation()=" + getEducation() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	private String email;
	private String dob;
	private String education;
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	
	
	
	
}

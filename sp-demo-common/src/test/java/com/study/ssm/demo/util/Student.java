package com.study.ssm.demo.util;

import java.io.Serializable;

public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String userName;
	private String password;
	private String address;
	private String mobilePhone;
	
	
	public Student() {
		super();
	}
	public Student(Long id, String userName, String password, String address,
			String mobilePhone) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobilePhone = mobilePhone;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", password="
				+ password + ", address=" + address + ", mobilePhone="
				+ mobilePhone + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	

}

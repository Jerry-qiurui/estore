package com.briup.estore.bean;

public class Customer {
	private Integer id;
	private String username;
	private String password;
	private String zip;
	private String address;
	private String phone;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(Integer id, String username, String password, String zip, String address, String phone,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public Customer(String username, String password, String zip, String address, String phone, String email) {
		this(null, username, password, zip, address, phone, email);
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

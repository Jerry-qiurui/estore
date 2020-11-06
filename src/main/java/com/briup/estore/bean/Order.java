package com.briup.estore.bean;

import java.sql.Date;

public class Order {
	private String id;
	private Double total;
	private Date orderDate;
	private Customer customer;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(double price) {
		this.total = price;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order(String id, Double total, Date orderDate, Customer customer) {
		super();
		this.id = id;
		this.total = total;
		this.orderDate = orderDate;
		this.customer = customer;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package com.briup.estore.bean;

public class ShopCar {
	private Integer id;
	private Customer customer;
	private Book book;
	private Integer num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public ShopCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShopCar(Integer id, Customer customer, Book book, Integer num) {
		super();
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.num = num;
	}
	
}

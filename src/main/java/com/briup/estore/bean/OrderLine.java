package com.briup.estore.bean;

public class OrderLine {
	private Integer id;
	private Integer num;
	private Book book;
	private Order order;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderLine(Integer id, Integer num, Book book, Order order) {
		super();
		this.id = id;
		this.num = num;
		this.book = book;
		this.order = order;
	}
	public OrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

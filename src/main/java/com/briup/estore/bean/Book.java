package com.briup.estore.bean;

public class Book {
	private Integer id;
	private String name;
	private double price;
	private Category category;
	private String image;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Book(Integer id, String name, double price, Category category, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.image = image;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

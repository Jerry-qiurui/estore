package com.briup.estore.bean;

public class Category {
	private Integer id;
	private String name;
	private Category fatherCategory;
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
	public Category getFatherCategory() {
		return fatherCategory;
	}
	public void setFatherCategory(Category fatherCategory) {
		this.fatherCategory = fatherCategory;
	}
	public Category(Integer id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.fatherCategory = category;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", category=" + fatherCategory + "]";
	}
	
}

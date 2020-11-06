package com.briup.estore.dao;


import java.util.List;

import com.briup.estore.bean.Book;

public interface BookMapper {
	List<Book> findAll();
	Book selectById(Integer id);
	List<Book> findByName(String name);
	List<Book> findByCId(Integer id);
}

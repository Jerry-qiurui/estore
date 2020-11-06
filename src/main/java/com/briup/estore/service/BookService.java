package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class BookService {
	SqlSession sqlsession = MyBatisSqlSessionFactory.openSession(true);
	BookMapper mapper = sqlsession.getMapper(BookMapper.class);
	public Book selectById(Integer id) {
		Book book = mapper.selectById(id);
		return book;
	}
	
	public List<Book> findByName(String name){
		name = "%" + name + "%";
		List<Book> list = mapper.findByName(name);
		return list;
	}
	
	public List<Book> findByCId(Integer id){
		List<Book> list = mapper.findByCId(id);
		return list;
	}
//	@Test
//	public void test() {
//		
//		BookService service = new BookService();
//		List<Book> list = service.findByCId(3);
//		list.forEach(i->System.out.println(i));
//	}
}

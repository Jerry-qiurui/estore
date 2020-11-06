package com.briup.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class CategoryService {
	SqlSession sqlsession = MyBatisSqlSessionFactory.openSession(true);
	CategoryMapper mapper = sqlsession.getMapper(CategoryMapper.class);
	
	public void catePro(Integer id) {

	}
	
//	@Test
//	public void test() {
//		CategoryService service = new CategoryService();
//		List<Category> list = service.catePro();
//		list.forEach(i->System.out.println(i));
//	}
	
}

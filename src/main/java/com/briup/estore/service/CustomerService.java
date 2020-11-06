package com.briup.estore.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.util.EstoreException;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class CustomerService {
	SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
	CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

	public Customer login(String username, String password) throws EstoreException {
		Customer cus = mapper.SelectUserByName(username);
		if (cus == null) {
			throw new EstoreException("用户名不存在!");
		}else {
			if (cus.getPassword().equals(password)) {
				return cus;
			} else {
				throw new EstoreException("密码错误!");
			}
		}
	}

	public void register(Customer cus) throws EstoreException, IOException {
		//SqlSession openSession = MyBatisSqlSessionFactory.openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer username = mapper.SelectUserByName(cus.getUsername());
		if (username != null) {
			throw new EstoreException("用户名已存在");
		}
		mapper.InsertCus(cus);
	}

//	@Test
//	public void test() throws IOException {
//		CustomerService service = new CustomerService();
//		try {
//			service.register(new Customer("test1", "123456", "1234", "kunshan", "139155", "1@qq.com"));
//			Customer cus = service.login("qiurui", "123456");
//			System.out.println(cus);
//		} catch (EstoreException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}
//	}

}

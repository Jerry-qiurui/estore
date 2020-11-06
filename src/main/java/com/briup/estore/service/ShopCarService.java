package com.briup.estore.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.briup.estore.bean.ShopCar;
import com.briup.estore.dao.ShopCarMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class ShopCarService {
	SqlSession sqlsession = MyBatisSqlSessionFactory.openSession(true);
	ShopCarMapper mapper = sqlsession.getMapper(ShopCarMapper.class);
	public void addShopCar(String username,Integer bId) {
		ShopCar sc = mapper.findByUserAndBook(username, bId);
		if(sc == null) {
			mapper.insert(username, bId);
		}else {
			sc.setNum(sc.getNum()+1);
			mapper.addNum(sc);
		}
		
	}
	
//	@Test
//	public void test() {
//		mapper.delete("qiurui", 7);
//	}
}

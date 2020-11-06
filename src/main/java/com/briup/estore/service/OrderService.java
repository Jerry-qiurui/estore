package com.briup.estore.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.dao.OrderMapper;
import com.briup.estore.dao.ShopCarMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class OrderService {
	SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	ShopCarMapper shopCarMapper = sqlSession.getMapper(ShopCarMapper.class);
	public void addOrder(List<ShopCar> list,Customer cus) {
		Order order = new Order();
		order.setId("briup" + System.currentTimeMillis());
		double price = 0.0;
		for (ShopCar shopCar : list) {
			price += shopCar.getNum() * shopCar.getBook().getPrice();
		}
		order.setTotal(price);
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setCustomer(cus);
		mapper.save(order);
		for (ShopCar shopCar : list) {
			OrderLine orderLine = new OrderLine();
			orderLine.setBook(shopCar.getBook());
			orderLine.setNum(shopCar.getNum());
			orderLine.setOrder(order);
			mapper.saveLine(orderLine);
		}
		shopCarMapper.deleteByCus(cus.getId());
	}
	
	public List<Order> selectByCus(Customer cus) {
		List<Order> list = mapper.selectByCus(cus.getId());
		return list;
	}
	
	public List<OrderLine> selectLineByOrder(Order order){
		List<OrderLine> list = mapper.selectLineByOrder(order.getId());
		return list;
		
	}
	
	public void delOrderById(String id) {
		mapper.delLineByOrder(id);
		mapper.delOrderById(id);
	}
	
	
//	@Test
//	public void test() {
//		List<OrderLine> list = mapper.selectLineByOrder("briup1604322946094 ");
//		for (OrderLine orderLine : list) {
//			System.out.println(
//					orderLine.getBook().getName()
//					);
//			
//		}
//	}  
}


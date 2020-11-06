package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Order;
import com.briup.estore.bean.OrderLine;

public interface OrderMapper {
	void saveLine(OrderLine line);
	void save(Order order);
	List<Order> selectByCus(Integer id);
	List<OrderLine> selectLineByOrder(String id);
	void delOrderById(String id);
	void delLineByOrder(String id);
}


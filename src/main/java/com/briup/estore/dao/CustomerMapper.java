package com.briup.estore.dao;

import com.briup.estore.bean.Customer;

public interface CustomerMapper {
	Customer SelectUserByName(String name);
	void InsertCus(Customer cus);
}

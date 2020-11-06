package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.ShopCar;

public interface ShopCarMapper {
	ShopCar  findByUserAndBook(String username,Integer bId);
	void insert(String username,Integer bId);
	void addNum(ShopCar sc);
	List<ShopCar> findAllByCId(String username);
	void delete(String username,Integer bId);
	void deleteByCus(Integer id);
}

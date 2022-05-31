package com.mvc.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mvc.entity.products.Group;
import com.mvc.entity.products.Product;

@Service
public class ProductServiceImpl implements ProductService{
	// ProductServiceImpl Constructor 共用實作
	{
		if(groups.size() == 0) {
			// 初始化方品分類資料
			groups.put(1, new Group(11, "A"));
			groups.put(2, new Group(21, "B"));
			groups.put(3, new Group(31, "C"));		
		}
	}
	
	@Override
	public List<Product> query() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}

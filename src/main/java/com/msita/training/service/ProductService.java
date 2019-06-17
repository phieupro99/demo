package com.msita.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msita.training.dao.ProductDAO;
import com.msita.training.vo.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	public List<Product> getData(String type) {
		return productDAO.getData(type);
	}
	public Product getProduct(String id) {
		return productDAO.getProduct(id);
	}
}

package com.msita.training.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msita.training.service.ProductService;
import com.msita.training.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@ResponseBody
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public String getData(@RequestParam("type") String type, ModelMap model) {
		List<Product> lstProduct = productService.getData(type);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		/**
         * Write object to file
         */
        try {
            json=mapper.writeValueAsString(lstProduct);//Plain JSON
         } catch (Exception e) {
            e.printStackTrace();
        }
		return json;
	}
}

package com.msita.training.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.msita.training.service.ProductService;
import com.msita.training.vo.Product;

@Controller
@RequestMapping("/product-detail")
public class ProductDetailController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getData(@RequestParam("product") String productId,ModelMap model) {
		Product product = productService.getProduct(productId);
		model.addAttribute("product",product);
	      return "detail";
	}
}

package com.msita.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/cart")
public class ShoppingCartController {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public String cartPage(ModelMap model) {
		return "cart";
	}
	
	@RequestMapping(value =  "addCart",method = RequestMethod.GET)
	public String addToCart(@RequestParam("product") String product, HttpServletRequest request) {
		List<String> lst = (List<String>) request.getSession().getAttribute("cart");
		if(lst==null) {
			lst = new ArrayList<String>();
			lst.add(product);
		}else {
			lst.add(product);
		}
		request.getSession().setAttribute("cart",lst);
		return "redirect:/cart";
	}
	
	@ResponseBody
	@RequestMapping(value="/get",method = RequestMethod.GET)
	public String getData(ModelMap model,HttpServletRequest request) {
		List<String> lst = (List<String>) request.getSession().getAttribute("cart");
		List<Product> lstProduct=new ArrayList<Product>();
		if(lst!=null) {
			for(String product : lst) {
				lstProduct.add(productService.getProduct(product));
			}
		}
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
	
	@RequestMapping(value="/removeCart",method = RequestMethod.GET)
	public String removeData(@RequestParam("product") String product, ModelMap model,HttpServletRequest request) {
		List<String> lst = (List<String>) request.getSession().getAttribute("cart");
		if(lst==null) {
			lst= new ArrayList<String> ();
				
		}
		else lst.remove(product);
		return "redirect:/cart";
	}
	
	
}

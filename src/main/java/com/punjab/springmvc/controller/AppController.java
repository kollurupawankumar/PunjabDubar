package com.punjab.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.punjab.springmvc.others.Dish;
import com.punjab.springmvc.others.Order;



@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		return "index";
		
	}
	
	/**
	 * 
	 * First model is taking orders, this is the server module
	 * @param model
	 * @return
	 */
	
	
	
	
	
	
	
	
	@RequestMapping(value = { "/kitchen/orders/active" }, method = RequestMethod.GET)
	public String kitchenActiveOrders(ModelMap model) {
		model.put("orders", Order.getAllActiveKitchenSort());
	    model.put("dishes", Dish.all());
		return "orders-kitchen";
		
	}
	
	@RequestMapping(value = { "kitchen/orders/{id}" }, method = RequestMethod.GET)
	public String getKitchenOrdersById(ModelMap model, @PathVariable String id) {
		model.put("order", Order.find(Integer.parseInt(id)));
	    model.put("dishes", Dish.all());
		return "orders-kitchen";
		
	}
	
}
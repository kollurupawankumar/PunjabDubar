package com.punjab.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.punjab.springmvc.others.Dish;
import com.punjab.springmvc.others.Order;

@Controller
@RequestMapping("orders")
public class OrderController {
	
	/**
	 * This controller handles taking a new order
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String kitchenActiveOrders(ModelMap model) {
		model.put("orders", Order.getAllActive());
	    model.put("dishes", Dish.all());
		return "orders-active";
		
	}

}

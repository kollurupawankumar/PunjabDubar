package com.punjab.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.punjab.springmvc.others.Dish;
import com.punjab.springmvc.others.Order;

@Controller
@RequestMapping("servers")
public class ServerController {
	
	/**
	 * This method is used to get all the active orders
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/orders/active" }, method = RequestMethod.GET)
	public String kitchenActiveOrders(ModelMap model) {
		model.put("orders", Order.getAllActive());
	    model.put("dishes", Dish.all());
		return "orders-active";
		
	}
	
	
	@RequestMapping(value = { "/orders/new" }, method = RequestMethod.GET)
	public String newOrderByServer(ModelMap model) {
		model.put("orders", Order.getAllActive());
	    model.put("dishes", Dish.all());
	    model.put("dishclass", Dish.class);
		return "orders-new";
		
	}
	

}

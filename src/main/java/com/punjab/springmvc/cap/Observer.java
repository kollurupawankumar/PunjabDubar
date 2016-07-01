package com.punjab.springmvc.cap;
import java.util.ArrayList;

public class Observer {
	private ArrayList<Dish> dishesOrdered = new ArrayList<Dish>();
	
	public void updateList(Dish dish){
		dishesOrdered.add(dish);
	}
	
	public void resetList(){
		dishesOrdered =  new ArrayList<Dish>();
	}
	
	public Dish removeLastAdded() {
	  int size = dishesOrdered.size();
	  return dishesOrdered.remove(size - 1);
	}
	
	public ArrayList<Dish> getDishesOrdered(){
		return dishesOrdered;
	}
	
}

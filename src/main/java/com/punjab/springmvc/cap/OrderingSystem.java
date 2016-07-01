package com.punjab.springmvc.cap;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderingSystem {
	private ArrayList<Observer> listOfObserver = new ArrayList<Observer>();
	private ArrayList<Dish> dishes = new ArrayList<Dish>();
	private DishSize dishSize;
	
	
	//orders the dishes... has to interact with Ingredient class
	public Dish orderDish(String dishName){
		boolean dishExists = false;
		Dish dish = new Dish();
		
		//first: get all available dishes
		ArrayList<Dish> dishes = availableDishes();
		for(Dish d : dishes){
			//System.out.println(dishName + d.getName());
			//check if the name exists on our Dish list
			if((d.getName()).compareTo(dishName) == 0){
				dishExists = true;
				//dish = d;
				dish.setDishIngredients(d.getIngredients());// = d;
				dish.setName(d.getName());
				break;
			}
		}
		//check if it broke out of the loop from prior, if it did, Dish was found and can continue
		if(dishExists == false){
			System.out.println("Here!");
			return null;
		}

		//second: get dish sizes
		ArrayList<DishIngredient> ingredients = dishSize.getIngredients(dish.getIngredients());
		dish.setDishIngredients(ingredients);

		//tell observers
		notifyObservers(dish);
		
		return dish;
	}
	
	public Dish captureDish(String dishName){
		//boolean dishExists = false;
		//Dish dish = new Dish();
		
		//first: get all available dishes
		ArrayList<Dish> dishes = availableDishes();
		for(Dish d : dishes){
			//System.out.println(dishName + d.getName());
			//check if the name exists on our Dish list
			if((d.getName()).compareTo(dishName) == 0){
				//dishExists = true;
				//dish = d;
				//break;
				return d;
			}
		}
		return null;
	}
	
	public void replaceDish(Dish dish){
		for(Dish d : dishes){
			if((d.getName()).compareTo(dish.getName()) == 0){
				d = dish;
				//return true;
			}
		}
		//return false;
	}
	
	//adds an observer
	public void addObserver(Observer o){
		listOfObserver.add(o);
	}
	
	//returns the list of Dishes
	public ArrayList<Dish> availableDishes(){
		return dishes;
	}
	
	//set the list of Dishes at beginning
	public void setDishes(ArrayList<Dish> dishList){
		dishes = dishList;
	}
	
	//sets the DishSize according to class chosen
	public void setDishSize(DishSize size){
		dishSize = size;
	}
	
	public void notifyObservers(Dish dish) {
	  Iterator<Observer> itr = listOfObserver.iterator();
	  Observer obs;
	  
	  while(itr.hasNext()) {
	    obs = itr.next();
	    obs.updateList(dish);
	  }
	}
}

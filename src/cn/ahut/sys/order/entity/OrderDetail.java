package cn.ahut.sys.order.entity;

import cn.ahut.sys.food.entity.Food;

public class OrderDetail {

	 private String id;
	 private Order order;
	 private Food food;
	 private int foodCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	 
	 
}

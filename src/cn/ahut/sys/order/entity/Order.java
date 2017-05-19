package cn.ahut.sys.order.entity;

import java.util.Date;


import cn.ahut.login.entity.User;
import cn.ahut.sys.dinnertable.entity.DinnerTable;

/**
 * ¶©µ¥±í
 * @author Dell
 *
 */
public class Order {
	
	
    private String id ;
    private DinnerTable dinnerTable;
    private Date orderDate;	
    private String eatDate;
    private Double totalPrice;	       
    private int orderStatus; 
    private User user;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}
	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getEatDate() {
		return eatDate;
	}
	public void setEatDate(String eatDate) {
		this.eatDate = eatDate;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

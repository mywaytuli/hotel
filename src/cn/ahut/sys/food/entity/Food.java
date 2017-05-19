package cn.ahut.sys.food.entity;



import cn.ahut.sys.foodtype.entity.FoodType;

public class Food {

	  private String id;  
	  private String foodName ;
	  private FoodType foodType;
	  private Double price ;
	  private Double mprice;
	  private String remark;
	  private String img;
	  
	  
	public Food() {
		super();
		
	}
	
	
	public Food(String id, String foodName, FoodType foodType, Double price,
			Double mprice, String remark, String img) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodType = foodType;
		this.price = price;
		this.mprice = mprice;
		this.remark = remark;
		this.img = img;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMprice() {
		return mprice;
	}
	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	  
}

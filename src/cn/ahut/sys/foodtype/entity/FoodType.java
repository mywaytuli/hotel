package cn.ahut.sys.foodtype.entity;

public class FoodType {

	 private String id;
	 private String typeName;
	 
	 
	public FoodType() {
		super();
		
	}
	
	public FoodType(String id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	 
	 
	 
}

package cn.ahut.sys.dinnertable.entity;

public class TableDetail {
	private String id;
	private String eatDate;
	private DinnerTable dinnerTable;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEatDate() {
		return eatDate;
	}
	public void setEatDate(String eatDate) {
		this.eatDate = eatDate;
	}
	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}
	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}
	
	

}

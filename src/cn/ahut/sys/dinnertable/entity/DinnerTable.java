package cn.ahut.sys.dinnertable.entity;

import java.util.Date;

public class DinnerTable {
	private String id ;
	private String tableName; 
	public DinnerTable() {
		super();
		
	}
	
	public DinnerTable(String id, String tableName) {
		super();
		this.id = id;
		this.tableName = tableName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}

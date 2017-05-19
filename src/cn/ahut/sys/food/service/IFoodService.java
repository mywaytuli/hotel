package cn.ahut.sys.food.service;

import java.io.Serializable;


import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.ahut.sys.food.entity.Food;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

public interface IFoodService {
	
	
	//导出用户列表
		public void exportExcel(List<Food> foodList, ServletOutputStream outputStream);
	/**
	 * 添加
	 */
	public void save(Food food);
	
	/**
	 * 更新
	 */
	public void update(Food Food);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public Food findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<Food> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<Food> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

	
}

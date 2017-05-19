package cn.ahut.sys.order.service;

import java.io.Serializable;
import java.util.List;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.entity.Order;

public interface IOrderService {

	/**
	 * 添加
	 */
	public void save(Order order);
	
	/**
	 * 更新
	 */
	public void update(Order order);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public Order findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<Order> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<Order> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

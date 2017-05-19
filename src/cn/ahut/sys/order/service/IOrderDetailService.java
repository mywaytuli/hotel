package cn.ahut.sys.order.service;

import java.io.Serializable;

import java.util.List;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.entity.OrderDetail;

public interface IOrderDetailService {

	/**
	 * 添加
	 */
	public void save(OrderDetail orderDetail);
	
	/**
	 * 更新
	 */
	public void update(OrderDetail orderDetail);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public OrderDetail findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<OrderDetail> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<OrderDetail> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

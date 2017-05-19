package cn.ahut.sys.dinnertable.service;

import java.io.Serializable;

import java.util.List;

import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.sys.dinnertable.entity.TableDetail;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

public interface ITableDetailService {
	/**
	 * 添加
	 */
	public void save(TableDetail tableDetail);
	
	/**
	 * 更新
	 */
	public void update(TableDetail tableDetail);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public TableDetail findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<TableDetail> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<TableDetail> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);


}

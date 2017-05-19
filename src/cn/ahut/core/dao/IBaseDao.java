package cn.ahut.core.dao;

import java.io.Serializable;
import java.util.List;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;


/**
 * 抽取公共的dao接口
 * @author Dell
 *
 */
public interface IBaseDao<T> {

	/**
	 * 添加
	 */
	public void save(T entity);
	
	/**
	 * 更新
	 */
	public void update(T entity);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public T findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<T> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<T> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}

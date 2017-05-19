package cn.ahut.sys.foodtype.service;

import java.io.Serializable;



import java.util.List;

import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

/**
 * 菜系模块业务逻辑层接口设计
 * @author Dell
 *
 */
public interface IFoodTypeService {
	/**
	 * 添加
	 */
	public void save(FoodType foodType);
	
	/**
	 * 更新
	 */
	public void update(FoodType foodType);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public FoodType findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<FoodType> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<FoodType> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

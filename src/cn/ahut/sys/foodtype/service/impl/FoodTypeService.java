package cn.ahut.sys.foodtype.service.impl;

import java.io.Serializable;



import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.ahut.sys.foodtype.dao.IFoodTypeDao;
import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.sys.foodtype.service.IFoodTypeService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

/**
 * 菜系模块业务逻辑层接口实现
 * @author Dell
 *
 */
@Service
public class FoodTypeService  implements IFoodTypeService{
	
	@Resource
	private IFoodTypeDao foodTypeDao;
	@Override
	public void save(FoodType foodType) {
		foodTypeDao.save(foodType);
	}

	@Override
	public void update(FoodType foodType) {
		foodTypeDao.update(foodType);
	}

	@Override
	public void delete(Serializable id) {
		foodTypeDao.delete(id);
	}

	@Override
	public FoodType findById(Serializable id) {
		
		return foodTypeDao.findById(id);
	}

	@Override
	public List<FoodType> getAll() {
		
		return foodTypeDao.getAll();
	}

	@Override
	public List<FoodType> getAll(QueryHelper queryHelper) {
		
		return foodTypeDao.getAll(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		
		return foodTypeDao.getPageResult(queryHelper, pageNo, pageSize);
	}
	

	
}

	


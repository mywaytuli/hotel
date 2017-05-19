package cn.ahut.sys.food.service.impl;

import java.io.Serializable;




import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import cn.ahut.sys.food.dao.IFoodDao;
import cn.ahut.sys.food.entity.Food;
import cn.ahut.sys.food.service.IFoodService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.ExcelUtil;
import cn.ahut.core.util.QueryHelper;

@Service
public class FoodService  implements IFoodService{

	@Resource
	private IFoodDao foodDao;
	
	@Override
	public void save(Food food) {
		foodDao.save(food);
	}

	@Override
	public void update(Food Food) {
		foodDao.update(Food);
	}

	@Override
	public void delete(Serializable id) {
		foodDao.delete(id);
	}

	@Override
	public Food findById(Serializable id) {
		
		return foodDao.findById(id);
	}

	@Override
	public List<Food> getAll() {
		
		return foodDao.getAll();
	}

	@Override
	public List<Food> getAll(QueryHelper queryHelper) {
		
		return foodDao.getAll(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		
		return foodDao.getPageResult(queryHelper, pageNo, pageSize);
	}

	@Override
	public void exportExcel(List<Food> foodList, ServletOutputStream outputStream) {
		ExcelUtil.exportFoodExcel(foodList, outputStream);
	}
	
	
}

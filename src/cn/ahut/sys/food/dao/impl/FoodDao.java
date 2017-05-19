package cn.ahut.sys.food.dao.impl;

import java.io.Serializable;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.ahut.sys.food.dao.IFoodDao;
import cn.ahut.sys.food.entity.Food;
import cn.ahut.core.dao.impl.BaseDao;

@Repository
public class FoodDao extends BaseDao<Food> implements IFoodDao {
	
	
}

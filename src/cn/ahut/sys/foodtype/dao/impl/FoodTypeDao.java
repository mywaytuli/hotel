package cn.ahut.sys.foodtype.dao.impl;

import java.io.Serializable;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.ahut.sys.foodtype.dao.IFoodTypeDao;
import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.core.dao.impl.BaseDao;


/**
 * 菜系模块 dao接口实现
 * @author Dell
 *
 */
@Repository
public class FoodTypeDao extends BaseDao<FoodType> implements IFoodTypeDao {
	
}

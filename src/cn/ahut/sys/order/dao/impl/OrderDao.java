package cn.ahut.sys.order.dao.impl;

import org.springframework.stereotype.Repository;

import cn.ahut.core.dao.impl.BaseDao;
import cn.ahut.sys.order.dao.IOrderDao;
import cn.ahut.sys.order.entity.Order;

@Repository
public class OrderDao extends BaseDao<Order> implements IOrderDao{

}

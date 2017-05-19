package cn.ahut.sys.order.dao.impl;

import org.springframework.stereotype.Repository;


import cn.ahut.core.dao.impl.BaseDao;
import cn.ahut.sys.order.dao.IOrderDetailDao;
import cn.ahut.sys.order.entity.OrderDetail;

@Repository
public class OrderDetailDao extends BaseDao<OrderDetail> implements IOrderDetailDao{

}

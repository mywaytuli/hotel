package cn.ahut.sys.order.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.dao.IOrderDao;
import cn.ahut.sys.order.entity.Order;
import cn.ahut.sys.order.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	
	@Resource
	private IOrderDao orderDao;
	@Override
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	public void update(Order order) {
		orderDao.update(order);
	}

	@Override
	public void delete(Serializable id) {
		orderDao.delete(id);
	}

	@Override
	public Order findById(Serializable id) {
		
		return orderDao.findById(id);
	}

	@Override
	public List<Order> getAll() {
		
		return orderDao.getAll();
	}

	@Override
	public List<Order> getAll(QueryHelper queryHelper) {
		
		return orderDao.getAll(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		
		return orderDao.getPageResult(queryHelper, pageNo, pageSize);
	}

}

package cn.ahut.sys.order.service.impl;

import java.io.Serializable;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.dao.IOrderDetailDao;
import cn.ahut.sys.order.entity.OrderDetail;
import cn.ahut.sys.order.service.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService {
	
	@Resource
	private IOrderDetailDao orderDetailDao;

	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}

	@Override
	public void update(OrderDetail orderDetail) {
		orderDetailDao.update(orderDetail);
	}

	@Override
	public void delete(Serializable id) {
		orderDetailDao.delete(id);
	}

	@Override
	public OrderDetail findById(Serializable id) {
		
		return orderDetailDao.findById(id);
	}

	@Override
	public List<OrderDetail> getAll() {
		
		return orderDetailDao.getAll();
	}

	@Override
	public List<OrderDetail> getAll(QueryHelper queryHelper) {
		
		return orderDetailDao.getAll(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		
		return orderDetailDao.getPageResult(queryHelper, pageNo, pageSize);
	}
	

}

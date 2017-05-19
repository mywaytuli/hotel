package cn.ahut.sys.order.service;

import java.io.Serializable;

import java.util.List;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.entity.OrderDetail;

public interface IOrderDetailService {

	/**
	 * ���
	 */
	public void save(OrderDetail orderDetail);
	
	/**
	 * ����
	 */
	public void update(OrderDetail orderDetail);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public OrderDetail findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<OrderDetail> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<OrderDetail> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

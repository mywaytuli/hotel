package cn.ahut.sys.order.service;

import java.io.Serializable;
import java.util.List;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.sys.order.entity.Order;

public interface IOrderService {

	/**
	 * ���
	 */
	public void save(Order order);
	
	/**
	 * ����
	 */
	public void update(Order order);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public Order findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<Order> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<Order> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

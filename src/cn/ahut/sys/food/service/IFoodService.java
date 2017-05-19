package cn.ahut.sys.food.service;

import java.io.Serializable;


import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.ahut.sys.food.entity.Food;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

public interface IFoodService {
	
	
	//�����û��б�
		public void exportExcel(List<Food> foodList, ServletOutputStream outputStream);
	/**
	 * ���
	 */
	public void save(Food food);
	
	/**
	 * ����
	 */
	public void update(Food Food);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public Food findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<Food> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<Food> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

	
}

package cn.ahut.sys.dinnertable.service;

import java.io.Serializable;

import java.util.List;

import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

public interface IDinnerTableService {
	/**
	 * ���
	 */
	public void save(DinnerTable dinnerTable);
	
	/**
	 * ����
	 */
	public void update(DinnerTable dinnerTable);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public DinnerTable findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<DinnerTable> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<DinnerTable> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);


}

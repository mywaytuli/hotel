package cn.ahut.sys.dinnertable.service;

import java.io.Serializable;

import java.util.List;

import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.sys.dinnertable.entity.TableDetail;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

public interface ITableDetailService {
	/**
	 * ���
	 */
	public void save(TableDetail tableDetail);
	
	/**
	 * ����
	 */
	public void update(TableDetail tableDetail);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public TableDetail findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<TableDetail> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<TableDetail> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);


}

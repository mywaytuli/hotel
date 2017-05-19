package cn.ahut.core.dao;

import java.io.Serializable;
import java.util.List;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;


/**
 * ��ȡ������dao�ӿ�
 * @author Dell
 *
 */
public interface IBaseDao<T> {

	/**
	 * ���
	 */
	public void save(T entity);
	
	/**
	 * ����
	 */
	public void update(T entity);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public T findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<T> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<T> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}

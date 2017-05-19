package cn.ahut.sys.foodtype.service;

import java.io.Serializable;



import java.util.List;

import cn.ahut.sys.foodtype.entity.FoodType;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

/**
 * ��ϵģ��ҵ���߼���ӿ����
 * @author Dell
 *
 */
public interface IFoodTypeService {
	/**
	 * ���
	 */
	public void save(FoodType foodType);
	
	/**
	 * ����
	 */
	public void update(FoodType foodType);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public FoodType findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<FoodType> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<FoodType> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);

}

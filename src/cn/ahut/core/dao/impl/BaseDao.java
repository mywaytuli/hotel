package cn.ahut.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.ahut.core.dao.IBaseDao;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;

public  class BaseDao<T>  implements IBaseDao<T>{
	
	// ��ǰ������ʵ�ʵ�bean����
		Class<T> clazz;
	
		// ���䷺��
		public BaseDao(){
			Type type = this.getClass().getGenericSuperclass();
			// ת��Ϊ����������
			ParameterizedType pt = (ParameterizedType) type;  // BaseDao<Employee>
			// �õ�ʵ������
			Type types[] = pt.getActualTypeArguments();
			// ��ȡʵ������
			clazz = (Class<T>) types[0];
		}
	@Resource
	protected SessionFactory sessionFactory;
	
	
	
	@Override
	public void save(T entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}

	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		sessionFactory.getCurrentSession().delete(findById(id));
		
	}

	@Override
	public T findById(Serializable id) {
		
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		
		return  sessionFactory.getCurrentSession().createQuery("FROM "+clazz.getSimpleName()).list();
	}

	@Override
	public List<T> getAll(QueryHelper queryHelper) {
		Query q = sessionFactory.getCurrentSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters!=null){
			for (int i = 0; i < parameters.size(); i++) {
				q.setParameter(i, parameters.get(i));
			}
		}
		return q.list();
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,int pageSize) {
		Query q = sessionFactory.getCurrentSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters!=null){
			for (int i = 0; i < parameters.size(); i++) {
				q.setParameter(i, parameters.get(i));
			}
		}
		
		if(pageNo<1) pageNo=1;
		q.setFirstResult((pageNo-1)*pageSize);
		q.setMaxResults(pageSize);
		List items = q.list();
		//��ȡ�ܼ�¼��
		Query queryCount = sessionFactory.getCurrentSession().createQuery(queryHelper.getQueryCountHql());
		if(parameters!=null){
			for (int i = 0; i < parameters.size(); i++) {
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		Long totalCount = (Long) queryCount.uniqueResult();
		return new PageResult(totalCount, pageNo, pageSize, items);
	}

}

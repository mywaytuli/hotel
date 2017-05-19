package cn.ahut.login.service;

import java.io.Serializable;


import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.login.entity.User;

public interface IUserService {

	//�����û��б�
	public void exportExcel(List<User> userList, ServletOutputStream outputStream);
	
	/**
	 * ���
	 */
	public void save(User user);
	
	/**
	 * ����
	 */
	public void update(User user);
	
	/**
	 * ɾ��
	 */
	public void delete(Serializable id);
	
	/**
	 * ����������ѯ
	 */
	public User findById(Serializable id);
	
	/**
	 * ��ѯȫ��
	 */
	public List<User> getAll();
	
	/**
	 * ������ѯʵ���б�
	 */
	public List<User> getAll(QueryHelper queryHelper);
	
	/**
	 * ��ҳ������ѯʵ���б�--��ѯ����queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
	//�����û����ʺź������ѯ�û��б�
	public List<User> findUsersByAccountAndPwd(String account, String pwd);

}

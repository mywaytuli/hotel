package cn.ahut.login.service;

import java.io.Serializable;


import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.login.entity.User;

public interface IUserService {

	//导出用户列表
	public void exportExcel(List<User> userList, ServletOutputStream outputStream);
	
	/**
	 * 添加
	 */
	public void save(User user);
	
	/**
	 * 更新
	 */
	public void update(User user);
	
	/**
	 * 删除
	 */
	public void delete(Serializable id);
	
	/**
	 * 根据主键查询
	 */
	public User findById(Serializable id);
	
	/**
	 * 查询全部
	 */
	public List<User> getAll();
	
	/**
	 * 条件查询实体列表
	 */
	public List<User> getAll(QueryHelper queryHelper);
	
	/**
	 * 分页条件查询实体列表--查询助手queryHelper
	 */
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
	//根据用户的帐号和密码查询用户列表
	public List<User> findUsersByAccountAndPwd(String account, String pwd);

}

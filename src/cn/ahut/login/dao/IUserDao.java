package cn.ahut.login.dao;

import java.util.List;

import cn.ahut.core.dao.IBaseDao;
import cn.ahut.login.entity.User;



public interface IUserDao extends IBaseDao<User>{
	
	//根据用户的帐号和密码查询用户列表
		public List<User> findUsersByAccountAndPwd(String account, String pwd);

}

package cn.ahut.login.dao;

import java.util.List;

import cn.ahut.core.dao.IBaseDao;
import cn.ahut.login.entity.User;



public interface IUserDao extends IBaseDao<User>{
	
	//�����û����ʺź������ѯ�û��б�
		public List<User> findUsersByAccountAndPwd(String account, String pwd);

}

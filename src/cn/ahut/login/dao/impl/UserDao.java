package cn.ahut.login.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import cn.ahut.core.dao.impl.BaseDao;
import cn.ahut.login.dao.IUserDao;
import cn.ahut.login.entity.User;

@Repository
public class UserDao extends BaseDao<User> implements IUserDao{
	
	


	@Override
	public List<User> findUsersByAccountAndPwd(String account, String pwd) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE account=? AND pwd=?");
		query.setParameter(0, account);
		query.setParameter(1, pwd);
		return query.list();
	}

}

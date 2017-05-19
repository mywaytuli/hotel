package cn.ahut.login.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.ExcelUtil2;
import cn.ahut.core.util.QueryHelper;
import cn.ahut.login.dao.IUserDao;
import cn.ahut.login.entity.User;
import cn.ahut.login.service.IUserService;

@Service
public class UserService implements IUserService{

	@Resource
	private IUserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
	}

	@Override
	public User findById(Serializable id) {
		
		return userDao.findById(id);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

	@Override
	public List<User> getAll(QueryHelper queryHelper) {
		
		return userDao.getAll(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,
			int pageSize) {
		
		return userDao.getPageResult(queryHelper, pageNo, pageSize);
	}

	@Override
	public List<User> findUsersByAccountAndPwd(String account, String pwd) {
		
		return userDao.findUsersByAccountAndPwd(account, pwd);
	}

	@Override
	public void exportExcel(List<User> userList,ServletOutputStream outputStream) {
		ExcelUtil2.exportUserExcel(userList, outputStream);
	}
	

}

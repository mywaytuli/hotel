package cn.ahut.sys.dinnertable.service.impl;

import java.io.Serializable;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ahut.sys.dinnertable.dao.IDinnerTableDao;
import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.sys.dinnertable.service.IDinnerTableService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
@Service
public class DinnerTableService implements IDinnerTableService{

	@Resource
	private IDinnerTableDao dinnerTableDao;
	@Override
	public void save(DinnerTable dinnerTable) {
		dinnerTableDao.save(dinnerTable);
	}

	@Override
	public void update(DinnerTable dinnerTable) {
		dinnerTableDao.update(dinnerTable);
	}

	@Override
	public void delete(Serializable id) {
		dinnerTableDao.delete(id);
	}

	@Override
	public DinnerTable findById(Serializable id) {
		
		return dinnerTableDao.findById(id);
	}

	@Override
	public List<DinnerTable> getAll() {
		
		return dinnerTableDao.getAll();
	}

	@Override
	public List<DinnerTable> getAll(QueryHelper queryHelper) {
		
		return dinnerTableDao.getAll(queryHelper);
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,int pageSize) {
		
		return dinnerTableDao.getPageResult(queryHelper, pageNo, pageSize);
	}
}

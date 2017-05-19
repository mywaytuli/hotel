package cn.ahut.sys.dinnertable.service.impl;

import java.io.Serializable;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ahut.sys.dinnertable.dao.IDinnerTableDao;
import cn.ahut.sys.dinnertable.dao.ITableDetailDao;
import cn.ahut.sys.dinnertable.entity.DinnerTable;
import cn.ahut.sys.dinnertable.entity.TableDetail;
import cn.ahut.sys.dinnertable.service.IDinnerTableService;
import cn.ahut.sys.dinnertable.service.ITableDetailService;
import cn.ahut.core.page.PageResult;
import cn.ahut.core.util.QueryHelper;
@Service
public class TableDetailService implements ITableDetailService{

	@Resource
	private ITableDetailDao tableDetailDao;
	
	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo,int pageSize) {
		
		return tableDetailDao.getPageResult(queryHelper, pageNo, pageSize);
	}

	@Override
	public void save(TableDetail tableDetail) {
		tableDetailDao.save(tableDetail);
	}

	@Override
	public void update(TableDetail tableDetail) {
		tableDetailDao.update(tableDetail);
	}

	@Override
	public void delete(Serializable id) {
		tableDetailDao.delete(id);
	}

	@Override
	public TableDetail findById(Serializable id) {
		
		return tableDetailDao.findById(id);
	}

	@Override
	public List<TableDetail> getAll() {
		
		return tableDetailDao.getAll();
	}

	@Override
	public List<TableDetail> getAll(QueryHelper queryHelper) {
		
		return tableDetailDao.getAll(queryHelper);
	}
}

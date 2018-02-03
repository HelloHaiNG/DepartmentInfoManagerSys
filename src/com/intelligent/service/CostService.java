package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.CostDao;
import com.intelligent.pojo.Cost;
import com.intelligent.pojo.PageBean;

@Transactional
public class CostService {
	private CostDao costDao;
	public void setCostDao(CostDao costDao) {
		this.costDao = costDao;
	}
	
	public void add(Cost cost) {
		costDao.add(cost);
	}

	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = costDao.findCount();
		pageBean.setTotalCount(totalCount);
		//页记录数
		int pageSize = 20;
		pageBean.setPageSize(pageSize);
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//页开始记录数
		int begin = (currentPage-1)*pageSize;
		pageBean.setBegin(begin);
		List<Cost> list = costDao.findListPage(begin,pageSize);
		pageBean.setListCosts(list);
		return pageBean;
	}

	public Cost findByCid(int parseInt) {
		return costDao.findByCid(parseInt);
	}

	public void update(Cost cost) {
		costDao.update(cost);
	}

	public void deleteByCid(Cost cost) {
		costDao.deleteByCid(cost);
	}

	public List<Cost> all() {
		return costDao.all();
	}

}

package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.IndustryDao;
import com.intelligent.pojo.Industry;
import com.intelligent.pojo.PageBean;

@Transactional
public class IndustryService {
	private IndustryDao industryDao;
	public void setIndustryDao(IndustryDao industryDao) {
		this.industryDao = industryDao;
	}
	
	public void add(Industry industry) {
		industryDao.add(industry);
	}

	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = industryDao.findCount();
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
		List<Industry> list = industryDao.findListPage(begin,pageSize);
		pageBean.setListIndustries(list);
		return pageBean;
	}

	public Industry findById(int parseInt) {
		return industryDao.findById(parseInt);
	}

	public void update(Industry industry) {
		industryDao.update(industry);
	}

	public void deleteById(Industry industry) {
		industryDao.deleteById(industry);
	}

	public List<Industry> all() {
		return industryDao.all();
	}

}

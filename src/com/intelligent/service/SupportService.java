package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.SupportDao;
import com.intelligent.pojo.PageBean;
import com.intelligent.pojo.Support;
@Transactional
public class SupportService {
	private SupportDao supportDao;
	public void setSupportDao(SupportDao supportDao) {
		this.supportDao = supportDao;
	}
	public void add(Support support) {
		supportDao.add(support);
	}
	
	public PageBean listByEmployee(Integer currentPage, String sresname) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = supportDao.findCountByEmployee(sresname);
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
		List<Support> list = supportDao.findListPageByEmployee(begin,pageSize,sresname);
		pageBean.setListSupports(list);
		return pageBean;
	}
	
	public Support findBySid(String sid) {
		return supportDao.findBySid(sid);
	}
	
	public void deleteBySid(Support support) {
		supportDao.deleteBySid(support);
	}
	
	public List<Support> listBySname(String sname) {
		return supportDao.listBySname(sname);
	}
	
	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = supportDao.findCount();
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
		List<Support> list = supportDao.findListPage(begin,pageSize);
		pageBean.setListSupports(list);
		return pageBean;
	}
	
	public void update(Support support) {
		supportDao.update(support);
	}
	public List<Support> all() {
		return supportDao.all();
	}

}

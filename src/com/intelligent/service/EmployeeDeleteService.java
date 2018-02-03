package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.EmployeeDeleteDao;
import com.intelligent.pojo.EmployeeDelete;
import com.intelligent.pojo.PageBean;

@Transactional
public class EmployeeDeleteService {
	private EmployeeDeleteDao employeeDeleteDao;
	public void setEmployeeDeleteDao(EmployeeDeleteDao employeeDeleteDao) {
		this.employeeDeleteDao = employeeDeleteDao;
	}

	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = employeeDeleteDao.findCount();
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
		List<EmployeeDelete> list = employeeDeleteDao.findListPage(begin,pageSize);
		pageBean.setListEmployeeDeletes(list);
		return pageBean;
	}

	public EmployeeDelete findByEdnumber(String ednumber) {
		return employeeDeleteDao.findByEdnumber(ednumber);
	}

	public void deleteByEnumber(EmployeeDelete employeeDelete) {
		employeeDeleteDao.deleteByEnumber(employeeDelete);
	}

	public List<EmployeeDelete> all() {
		return employeeDeleteDao.all();
	}

	public void delete(List<EmployeeDelete> employeeDeletes) {
		employeeDeleteDao.delete(employeeDeletes);
	}

	public List<EmployeeDelete> findByGroup(String gname) {
		return employeeDeleteDao.findByGroup(gname);
	}

	public void add(EmployeeDelete employeeDelete) {
		employeeDeleteDao.add(employeeDelete);
	}

}

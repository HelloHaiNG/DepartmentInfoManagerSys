package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.ProjectDao;
import com.intelligent.pojo.PageBean;
import com.intelligent.pojo.Project;

@Transactional
public class ProjectService {
	private ProjectDao projectDao;
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	public List<Project> projectList() {
		return projectDao.projectList();
	}

	public void add(Project project) {
		projectDao.add(project);
	}

	public PageBean listByUnumber(Integer currentPage, String unumber) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = projectDao.findCountByUnumber(unumber);
		pageBean.setTotalCount(totalCount);
		//页记录数
		int pageSize = 1;
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
		List<Project> list = projectDao.findListPage(begin,pageSize);
		pageBean.setListProjects(list);
		return pageBean;
	}

	public Project findByPnumber(String pnumber) {
		return projectDao.findByPnumber(pnumber);
	}

	public void update(Project project) {
		projectDao.update(project);
	}

	public void deleteByPnumber(Project project) {
		projectDao.deleteByPnumber(project);
	}

	public void delete(List<Project> projects) {
		projectDao.delete(projects);
	}

	public List<Project> all() {
		return projectDao.all();
	}

	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = projectDao.findCount();
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
		List<Project> list = projectDao.findListPage(begin,pageSize);
		pageBean.setListProjects(list);
		return pageBean;
	}

}

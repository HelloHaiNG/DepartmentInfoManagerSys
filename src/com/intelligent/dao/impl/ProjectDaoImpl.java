package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.ProjectDao;
import com.intelligent.pojo.Project;

public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	@SuppressWarnings("all")
	@Override
	public List<Project> projectList() {
		return (List<Project>) this.getHibernateTemplate().find("from Project");
	}

	@Override
	public void add(Project project) {
		this.getHibernateTemplate().save(project);
	}

	@SuppressWarnings("all")
	@Override
	public int findCountByUnumber(String unumber) {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Project where unumber=?",unumber);
		if(list.size()!=0 && list!=null){
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int totalCount = lobj.intValue();
			return totalCount;
		}
		return 0;
	}

	@SuppressWarnings("all")
	@Override
	public List<Project> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Project.class);
		List<Project> list = (List<Project>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public Project findByPnumber(String pnumber) {
		return this.getHibernateTemplate().get(Project.class, pnumber);
	}

	@Override
	public void update(Project project) {
		this.getHibernateTemplate().update(project);
	}

	@Override
	public void deleteByPnumber(Project project) {
		this.getHibernateTemplate().delete(project);
	}

	@Override
	public void delete(List<Project> projects) {
		this.getHibernateTemplate().deleteAll(projects);
	}

	@SuppressWarnings("all")
	@Override
	public List<Project> all() {
		return (List<Project>) this.getHibernateTemplate().find("from Project");
	}

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Project");
		if(list.size()!=0 && list!=null){
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int totalCount = lobj.intValue();
			return totalCount;
		}
		return 0;
	}

}

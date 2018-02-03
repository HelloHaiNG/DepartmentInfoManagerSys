package com.intelligent.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.intelligent.dao.DeviceDao;
import com.intelligent.pojo.Device;

public class DeviceDaoImpl extends HibernateDaoSupport implements DeviceDao {

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Device");
		if(list.size()!=0 && list!=null){
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int totalCount = lobj.intValue();
			return totalCount;
		}
		return 0;
	}

	@Override
	public void add(Device device) {
		this.getHibernateTemplate().save(device);
	}

	@SuppressWarnings("all")
	@Override
	public List<Device> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Device.class);
		List<Device> list = (List<Device>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public Device findByDid(int parseInt) {
		return this.getHibernateTemplate().get(Device.class, parseInt);
	}

	@Override
	public void update(Device device) {
		this.getHibernateTemplate().update(device);
	}

	@Override
	public void delete(Device device) {
		this.getHibernateTemplate().delete(device);
	}

	@SuppressWarnings("all")
	@Override
	public List<Device> all() {
		return (List<Device>) this.getHibernateTemplate().find("from Device");
	}

}

package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.DeviceDao;
import com.intelligent.pojo.Device;
import com.intelligent.pojo.PageBean;

@Transactional
public class DeviceService {
	private DeviceDao deviceDao;
	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}
	
	public int findCount() {
		return deviceDao.findCount();
	}

	public void add(Device device) {
		deviceDao.add(device);
	}

	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = deviceDao.findCount();
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
		List<Device> list = deviceDao.findListPage(begin,pageSize);
		pageBean.setListDevices(list);
		return pageBean;
	}

	public Device findByDid(int parseInt) {
		return deviceDao.findByDid(parseInt);
	}

	public void update(Device device) {
		deviceDao.update(device);
	}

	public void delete(Device device) {
		deviceDao.delete(device);
	}

	public List<Device> all() {
		return deviceDao.all();
	}

}

package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Device;

public interface DeviceDao {

	int findCount();

	void add(Device device);

	List<Device> findListPage(int begin, int pageSize);

	Device findByDid(int parseInt);

	void update(Device device);

	void delete(Device device);

	List<Device> all();

}

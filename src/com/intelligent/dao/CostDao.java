package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Cost;

public interface CostDao {

	void add(Cost cost);

	int findCount();

	List<Cost> findListPage(int begin, int pageSize);

	Cost findByCid(int parseInt);

	void update(Cost cost);

	void deleteByCid(Cost cost);

	List<Cost> all();

}

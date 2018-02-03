package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Industry;

public interface IndustryDao {

	void add(Industry industry);

	int findCount();

	List<Industry> findListPage(int begin, int pageSize);

	Industry findById(int parseInt);

	void update(Industry industry);

	void deleteById(Industry industry);

	List<Industry> all();

}

package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Support;

public interface SupportDao {

	void add(Support support);

	int findCountByEmployee(String sresname);

	List<Support> findListPage(int begin, int pageSize);

	Support findBySid(String sid);

	void deleteBySid(Support support);

	List<Support> listBySname(String sname);

	int findCount();

	void update(Support support);

	List<Support> findListPageByEmployee(int begin, int pageSize,
			String sresname);

	List<Support> all();

}

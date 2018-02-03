package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Notice;

public interface NoticeDao {

	void add(Notice notice);

	List<Notice> list();

	Notice findByNid(int parseInt);

	void deleteByNid(Notice notice);

	List<Notice> all();

	int findCount();

	List<Notice> findListPage(int begin, int pageSize);

}

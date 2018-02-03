package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Soft;

public interface SoftDao {

	void add(Soft soft);

	List<Soft> findByPnumber(String pnumber);

	List<Soft> list();

	void delete(List<Soft> softs);


}

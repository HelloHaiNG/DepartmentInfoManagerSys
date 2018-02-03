package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.SoftDao;
import com.intelligent.pojo.Soft;

@Transactional
public class SoftService {
	private SoftDao softDao;
	public void setSoftDao(SoftDao softDao) {
		this.softDao = softDao;
	}
	
	public void add(Soft soft) {
		softDao.add(soft);
	}

	public List<Soft> findByPnumber(String pnumber) {
		return softDao.findByPnumber(pnumber);
	}

	public List<Soft> list() {
		return softDao.list();
	}

	public void delete(List<Soft> softs) {
		softDao.delete(softs);
	}

}

package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.PcbDao;
import com.intelligent.pojo.Pcb;

@Transactional
public class PcbService {
	private PcbDao pcbDao;
	public void setPcbDao(PcbDao pcbDao) {
		this.pcbDao = pcbDao;
	}
	
	public void add(Pcb pcb) {
		pcbDao.add(pcb);
	}

	public List<Pcb> findByPnumber(String pnumber) {
		return pcbDao.findByPnumber(pnumber);
	}

	public List<Pcb> list() {
		return pcbDao.list();
	}

	public void delete(List<Pcb> pcbs) {
		pcbDao.delete(pcbs);
	}

}

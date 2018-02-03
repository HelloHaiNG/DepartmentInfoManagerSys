package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Pcb;

public interface PcbDao {

	void add(Pcb pcb);

	List<Pcb> findByPnumber(String pnumber);

	List<Pcb> list();

	void delete(List<Pcb> pcbs);

}

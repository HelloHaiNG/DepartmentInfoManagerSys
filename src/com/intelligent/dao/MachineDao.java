package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Machine;

public interface MachineDao {

	void add(Machine machine);

	List<Machine> findByPnumber(String pnumber);

	List<Machine> list();

	void delete(List<Machine> machines);

}

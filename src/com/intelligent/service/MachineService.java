package com.intelligent.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intelligent.dao.MachineDao;
import com.intelligent.pojo.Machine;

@Transactional
public class MachineService {
	private MachineDao machineDao;
	public void setMachineDao(MachineDao machineDao) {
		this.machineDao = machineDao;
	}
	
	public void add(Machine machine) {
		machineDao.add(machine);
	}

	public List<Machine> findByPnumber(String pnumber) {
		return machineDao.findByPnumber(pnumber);
	}

	public List<Machine> list() {
		return machineDao.list();
	}

	public void delete(List<Machine> machines) {
		machineDao.delete(machines);
	}

}

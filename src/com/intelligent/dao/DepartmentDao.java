package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Department;

public interface DepartmentDao {

	List<Department> list();

	Department findByDename(String dname);

	void add(Department department);

	void deleteByDname(Department department);

}

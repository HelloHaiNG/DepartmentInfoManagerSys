package com.intelligent.dao;

import java.util.List;

import com.intelligent.pojo.Employee;
public interface EmployeeDao {

	void add(Employee employee);

	Employee findByEnumber(String enumber);

	int findCount();

	List<Employee> findListPage(int begin, int pageSize);

	void update(Employee employee);

	void deleteByEmployee(Employee employee);

	List<Employee> all();

	void delete(List<Employee> employees);

	List<Employee> findByGroup(String gname);

	List<Employee> login(String unumber, String upwd);

}

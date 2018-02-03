package com.intelligent.dao;

import java.util.List;
import com.intelligent.pojo.EmployeeDelete;

public interface EmployeeDeleteDao {

	int findCount();

	List<EmployeeDelete> findListPage(int begin, int pageSize);

	EmployeeDelete findByEdnumber(String ednumber);

	void deleteByEnumber(EmployeeDelete employeeDelete);

	List<EmployeeDelete> all();

	void delete(List<EmployeeDelete> employeeDeletes);

	List<EmployeeDelete> findByGroup(String gname);

	void add(EmployeeDelete employeeDelete);

}

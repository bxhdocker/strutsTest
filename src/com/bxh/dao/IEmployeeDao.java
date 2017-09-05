package com.bxh.dao;

import java.util.List;

import com.bxh.entity.Employee;

public interface IEmployeeDao  {

	//查询员工
	List<Employee> getAll();
//	根据主键查询
	Employee findById(int id);
//	添加员工
	void save(Employee emp);
//	修改员工
	void update(Employee emp);
}

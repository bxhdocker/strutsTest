package com.bxh.dao;

import java.util.List;

import com.bxh.entity.Employee;

public interface IEmployeeDao  {

	//��ѯԱ��
	List<Employee> getAll();
//	����������ѯ
	Employee findById(int id);
//	���Ա��
	void save(Employee emp);
//	�޸�Ա��
	void update(Employee emp);
}

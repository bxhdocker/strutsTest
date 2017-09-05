package com.bxh.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bxh.dao.IEmployeeDao;
import com.bxh.dao.impl.EmployeeDao;
import com.bxh.entity.Employee;
import com.bxh.service.IEmployeeService;
import com.bxh.utils.JdbcUtils;

public class EmployeeService implements IEmployeeService{

	private IEmployeeDao employeeDao=new EmployeeDao();
	public List<Employee> getAll() {

		try {
			return employeeDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public Employee findById(int id) {
		try {
			return employeeDao.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}	
	}

	public void save(Employee emp) {
		// TODO Auto-generated method stub
		try {
			employeeDao.save(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void update(Employee emp) {
		try {
			employeeDao.update(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}

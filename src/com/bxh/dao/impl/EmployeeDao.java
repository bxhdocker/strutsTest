package com.bxh.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bxh.dao.IEmployeeDao;
import com.bxh.entity.Employee;
import com.bxh.utils.JdbcUtils;

public class EmployeeDao implements IEmployeeDao{

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from employee ";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from employee where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<Employee>(Employee.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}	
	}

	public void save(Employee emp) {
		// TODO Auto-generated method stub
		String sql="insert into employee(empName,workDate) values(?,?)";
		try {
			 JdbcUtils.getQuerrRunner().update(sql, emp.getEmpName(),emp.getWorkDate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void update(Employee emp) {
		// TODO Auto-generated method stub
		String sql="update employee set empName=?,workDate=? where id=?";
		try {
			 JdbcUtils.getQuerrRunner().update(sql, emp.getEmpName(),emp.getWorkDate(),emp.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}

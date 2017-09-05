package com.bxh.action;

import java.util.List;

import com.bxh.entity.Employee;
import com.bxh.service.IEmployeeService;
import com.bxh.service.impl.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

//员工管理Action
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	/*封装数据*/
	private Employee employee=new Employee();
	public void setEmp(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmp() {
		return employee;
	}
	
	/**调用service***/
	private IEmployeeService employeeService=new EmployeeService();
	
	public String save(){
		try {
			employeeService.save(employee);
			return list();
//			return "addsuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
	//显示列表页面
	public String list(){
		try {
			List<Employee> listEmp=employeeService.getAll();
			ActionContext.getContext().getContextMap().put("listEmp", listEmp);
			return "list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
	//实现驱动模型方法
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//进入修改页面
	public String viewUpdate(){
		try {
			int id=employee.getId();
			Employee emp=employeeService.findById(id);
			//数据回显技术
			ValueStack vs=ActionContext.getContext().getValueStack();
			vs.pop();
			vs.push(emp);
			return "update";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
	//修改成功后进入显示页面
	public String update(){
		try {
			employeeService.update(employee);
			return list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
}

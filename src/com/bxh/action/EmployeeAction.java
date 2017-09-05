package com.bxh.action;

import java.util.List;

import com.bxh.entity.Employee;
import com.bxh.service.IEmployeeService;
import com.bxh.service.impl.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

//Ա������Action
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	/*��װ����*/
	private Employee employee=new Employee();
	public void setEmp(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmp() {
		return employee;
	}
	
	/**����service***/
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
	//��ʾ�б�ҳ��
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
	//ʵ������ģ�ͷ���
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//�����޸�ҳ��
	public String viewUpdate(){
		try {
			int id=employee.getId();
			Employee emp=employeeService.findById(id);
			//���ݻ��Լ���
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
	//�޸ĳɹ��������ʾҳ��
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

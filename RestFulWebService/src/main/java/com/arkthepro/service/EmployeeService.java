package com.arkthepro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.arkthepro.dao.EmployeeDAO;
import com.arkthepro.model.Employee;

@Service("employeeService") //will be refered in Controller
public class EmployeeService {
	
	@Autowired
	EmployeeDAO empDAO;
	
	@Transactional(value="transactionManager")  /*here value transactionManager is default so it is optional specify only 
	                                                wheh we use custom name other than transactionManager */
	public void saveEmployeeService(Employee emp){
		System.out.println("---------------------------------Save Employee SERVICE");
        empDAO.saveEmployee(emp);
	}
	
	@Transactional
	public void updateEmployeeService(Employee emp){
		System.out.println("---------------------------------Update Employee SERVICE");
        empDAO.updateEmployee(emp);
	}
	@Transactional
	public void deleteEmployeeeService(Employee emp){
		System.out.println("---------------------------------Delete Employee SERVICE");
        empDAO.deleteEmployee(emp);
	}
	@Transactional
	public Employee getEmployeeService(Integer id){
		System.out.println("---------------------------------Get Employee SERVICE");
		return empDAO.getEmployee(id);

	}
	@Transactional
	public List<Employee> getAllEmployeeService(){
		System.out.println("---------------------------------Get All Employees SERVICE");
		System.out.println("---------------------------------Total Employees :" + empDAO.getAllEmployee().size());
		return empDAO.getAllEmployee();
	}

}

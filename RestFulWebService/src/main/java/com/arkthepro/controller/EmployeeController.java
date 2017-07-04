package com.arkthepro.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arkthepro.model.Employee;
import com.arkthepro.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	//Declare Service OBje
	@Resource(name="employeeService")
	EmployeeService restService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//Insert Employee
	@RequestMapping(value="/addEmployee",method=RequestMethod.GET)
	public @ResponseBody Map<String,List<Employee>> addEmployee(@RequestParam("emp_NAME") String name,@RequestParam("emp_AGE") String age,@RequestParam("emp_PASSWORD") String password) 
	{
		
		Map<String,List<Employee>> empJsont=new HashMap<String,List<Employee>>();
		try{
			Employee emp=new Employee();
			emp.setEmp_NAME(name);
			emp.setEmp_AGE(Integer.parseInt(age));  //Convert String to Int
			emp.setEmp_PASSWORD(password);
			
			//Insert New  employee to DB
			restService.saveEmployeeService(emp);
			//Get Updated List of Employees
			empJsont.put("Success", restService.getAllEmployeeService());
			
		}catch(Exception e){
			empJsont.put("Error", null);
			System.out.println("---------------------------------Error On Insert"+e);			
		}
		return empJsont;
		
	}
	
	//UPDATE  Employee Based on ID
	@RequestMapping(value="/updateEmployee")
	public @ResponseBody Map<String,List<Employee>> updateEmployee(@RequestParam("emp_ID") String id,@RequestParam("emp_NAME") String name,@RequestParam("emp_AGE") String age,@RequestParam("emp_PASSWORD") String password) 
	{
		
		Map<String,List<Employee>> empJsont=new HashMap<String,List<Employee>>();
		try{
			Employee emp=new Employee();
			emp.setEmp_ID(Integer.parseInt(id));
			emp.setEmp_NAME(name);
			emp.setEmp_AGE(Integer.parseInt(age));  //Convert String to Int
			emp.setEmp_PASSWORD(password);		
			//Insert New  employee to DB
			restService.updateEmployeeService(emp);
			//Get Updated List of Employees
			empJsont.put("Success", restService.getAllEmployeeService());
			
		}catch(Exception e){
			empJsont.put("Error", null);
			System.out.println("---------------------------------Error On UPDATE"+e);			
		}
		return empJsont;
		
	}
	//Delete Employee Based on ID
	@RequestMapping(value="/deleteEmployee")
	public @ResponseBody Map<String,List<Employee>> deleteEmployee(@RequestParam("emp_ID") String id) 
	{
		
		Map<String,List<Employee>> empJsont=new HashMap<String,List<Employee>>();
		try{
			Employee emp=new Employee();
			emp.setEmp_ID(Integer.parseInt(id));  //Convert String to Int			
			//Insert New  employee to DB
			restService.deleteEmployeeeService(emp);
			//Get Updated List of Employees
			empJsont.put("Success", restService.getAllEmployeeService());
			
		}catch(Exception e){
			empJsont.put("Error", null);
			System.out.println("---------------------------------Error On DELETE"+e);			
		}
		return empJsont;
		
	}
	//GET ALL Employee LIST
	@RequestMapping(value="/getAllEmployeeList")
	public @ResponseBody List<Employee> getAllEmployeeList(){
		List<Employee> empList = null;
		try{
			empList=restService.getAllEmployeeService();
			
		}catch(Exception e){
			System.out.println("---------------------------------Error On GET EMPLOYEE LIST"+e);			
		}
		return empList;
	}
	
	//GET ALL Employee with json
	@RequestMapping(value="/getAllEmployee")
	public @ResponseBody Map<String,List<Employee>> getAllEmployee() 
	{
		
		Map<String,List<Employee>> empJsont=new HashMap<String,List<Employee>>();
		try{
			empJsont.put("Success", restService.getAllEmployeeService());
			
		}catch(Exception e){
			empJsont.put("Error", null);
			System.out.println("---------------------------------Error On GET EMPLOYEE LIST JSON"+e);			
		}
		return empJsont;
		
	}
	//GET  Employee with json
	@RequestMapping(value="/getEmployeeObject")
	public @ResponseBody Employee getEmployeeObject(@RequestParam("emp_ID") String id) 
	{
		
		Employee emp = null;
		try{
			emp=restService.getEmployeeService(Integer.parseInt(id));
			
		}catch(Exception e){
			System.out.println("---------------------------------Error On GET EMPLOYEE OBJECT"+e);			
		}
		return emp;
		
	}
	
	//GET  Employee with json
	@RequestMapping(value="/getEmployee")
	public @ResponseBody Map<String,Employee> getEmployee(@RequestParam("emp_ID") String id) 
	{
		
		Map<String,Employee> empJsont=new HashMap<String,Employee>();
		try{
			empJsont.put("Success", restService.getEmployeeService(Integer.parseInt(id)));
			
		}catch(Exception e){
			empJsont.put("Error", null);
			System.out.println("---------------------------------Error On GET EMPLOYEE JSON"+e);			
		}
		return empJsont;
		
	}
	
}

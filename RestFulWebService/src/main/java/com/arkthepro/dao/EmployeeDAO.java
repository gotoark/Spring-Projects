package com.arkthepro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




import com.arkthepro.model.Employee;

@Repository
public class EmployeeDAO {
//Contains all the Functions related to DB Operation 
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void closeSession(){
		this.session.close();
	}
	public void setSession(Session session) {
		this.session = session;
	}

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory=sf;
		
	}
	
	//Save Function
	public void saveEmployee(Employee emp){
		System.out.println("---------------------------------Save Employee DAO ");
	      Session session =this.sessionFactory.getCurrentSession();
	      session.persist(emp);
	     // session.close();   
	}
	
	public void updateEmployee(Employee emp){
		System.out.println("---------------------------------Update Employee DAO");
		getSession().update(emp);
		//closeSession();
	}
	public void deleteEmployee(Employee emp){
		System.out.println("---------------------------------Delete Employee DAO");
		getSession().delete(emp);
		//closeSession();
	}
	public Employee getEmployee(Integer id){
		System.out.println("---------------------------------Get Employee DAO");
		Employee emp=(Employee)getSession().get(Employee.class, id);
		return emp;
		
	}	
	public List<Employee> getAllEmployee(){
		System.out.println("---------------------------------Get All Employees DAO");
		Session session = this.sessionFactory.getCurrentSession();
        List empList=session.createQuery("From Employee").list();  //here Employee is Not a Table Name its a Class Name Ref: HQL
		return empList;
		}
	
	
	
	
	
	
}

package com.arkthepro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class Employee {
	private static final long serialVersionUID=1L;
	
	@Id                   //defines Primary KEY 
	@GeneratedValue          //In hiber net must have atleast one Primary Key here generated means Auto increment
	@Column(name="ID")
	private Integer emp_ID;
	@Column(name="NAME")
	private String emp_NAME;
	@Column(name="AGE")
	private Integer emp_AGE;
	@Column(name="PASSWORD")
	private String emp_PASSWORD;
	
	
	public Integer getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(Integer emp_ID) {
		this.emp_ID = emp_ID;
	}
	public String getEmp_NAME() {
		return emp_NAME;
	}
	public void setEmp_NAME(String emp_NAME) {
		this.emp_NAME = emp_NAME;
	}
	public Integer getEmp_AGE() {
		return emp_AGE;
	}
	public void setEmp_AGE(Integer emp_AGE) {
		this.emp_AGE = emp_AGE;
	}
	public String getEmp_PASSWORD() {
		return emp_PASSWORD;
	}
	public void setEmp_PASSWORD(String emp_PASSWORD) {
		this.emp_PASSWORD = emp_PASSWORD;
	}


	
	
	
	
	
}

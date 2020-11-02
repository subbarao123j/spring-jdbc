package com.spring;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println(context);

		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");

		Employee employee = new Employee();

		employee.setId(207);

		employee.setName("Subba2");

		employee.setSalary(40000);

		int noOfRecords = dao.insertEmployee(employee);

		System.out.println("No of records=" + noOfRecords);
		List list = dao.readEmployees();
		
			
		//System.out.println(list);
		
		//System.out.println(dao.getEmployeeCount());
		
	int cnt = 	dao.countEmployee();
	
	System.out.println("total no of employees are "+cnt);
		

				
			
		}
		
		
		
		
		
		

	

}

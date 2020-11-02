package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println(context);

		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");

		Employee employee = new Employee();

		employee.setId(105);

		employee.setName("NIT");

		employee.setSalary(40000);

		int noOfRecords = dao.insertEmployee(employee);

		System.out.println("No of records=" + noOfRecords);

	}

}

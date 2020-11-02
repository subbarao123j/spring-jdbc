package com.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.util.LinkedCaseInsensitiveMap;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		System.out.println(context);

		EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");

		Employee employee = new Employee();

		employee.setId(128);

		employee.setName("JSRrrr");

		employee.setSalary(40000);

		int noOfRecords = dao.insertEmployee(employee);

		System.out.println("No of records=" + noOfRecords);

		List list = dao.readEmployees();

		for (Object object : list) {
			Map newMap = (LinkedCaseInsensitiveMap) object;
			System.out.println("id=" + newMap.get("id") + " " + "|" + "name=" + newMap.get("name") + "   ");

		}
		
		
		
		List list4 = dao.readEmployeesByName("JSRrrr");
		
		System.out.println(list4);

		/*
		 * List list2 = dao.readEmployeesById(101);
		 * 
		 * System.out.println(list2);
		 * 
		 * for (Object object : list2) {
		 * 
		 * Employee emp = (Employee)object;
		 * 
		 * System.out.println(emp);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * // Update method call
		 * 
		 * Employee employee = new Employee();
		 * 
		 * employee.setId(201);
		 * 
		 * employee.setName("JSRrrrJonnalagadda");
		 * 
		 * employee.setSalary(4000123);
		 * 
		 * // int updatedRows = dao.updateEmployee(employee); // //
		 * System.out.println(updatedRows);
		 * 
		 * int deleteRows = dao.deleteEmployee(103);
		 * 
		 * System.out.println(deleteRows);
		 * 
		 * // List list3= dao.readEmployeesByName("NIT"); // //
		 * System.out.println(list3); //
		 * 
		 * 
		 * }
		 */

	}
}
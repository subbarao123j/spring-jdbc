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

		List<Employee> list = dao.readEmployeesByRSE();

		for (Employee employee2 : list) {

			System.out.println("Emp id =" + employee2.getId());
			System.out.println("Emp Name" + employee2.getName());
			System.out.println("Emp salary=" + employee2.getSalary());
		}
	}
}
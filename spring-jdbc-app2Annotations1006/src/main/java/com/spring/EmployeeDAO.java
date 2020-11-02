package com.spring;


import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component

public class EmployeeDAO {
	
	@Autowired 

	private JdbcTemplate jdbcTemplate;

	

	public int insertEmployee(Employee employee) {

		// define query

		String insertSQL = "insert into employee values (?,?,?)";

		// To access properties from POJO

		Object[] params = new Object[] { employee.getId(), employee.getName(), employee.getSalary() };

		// Define SQL types respective to POJO class;

		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.FLOAT };

		System.out.println("jdbcTemplate is:" + jdbcTemplate);

		int row = jdbcTemplate.update(insertSQL, params, types);

		return row;

	}
	
	public List readEmployees() {
		
		
		
		String readQuery ="select * from employee";
		
		List list = jdbcTemplate.queryForList(readQuery);
		
		return list;
		
		
		
		
	}
	
	
	
	

}

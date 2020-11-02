package com.spring;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertEmployee(Employee employee) {

		// define query

		String insertSQL = "insert into employee values (?,?,?)";

		// To access properties from POJO

		Object[] params = new Object[] { employee.getId(), employee.getName(), employee.getSalary() };

		// Define SQL types respective to POJO class;

		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.FLOAT };

		System.out.println("Employee record inserted" + jdbcTemplate);

		int row = jdbcTemplate.update(insertSQL, params, types);  //while loading the container your jdbc is ready 

		return row;

	}

}

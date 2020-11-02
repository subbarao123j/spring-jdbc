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

//String readQuery = "select id, name  from employee";
		String readQuery = "select *  from employee";

		List list = jdbcTemplate.queryForList(readQuery);

		return list;

	}

	public List readEmployeesById(int id) {

		String readQuery = "select id, name  from employee where id=" + id;
		// String readQuery = "select * from employee";

		List list = jdbcTemplate.queryForList(readQuery);

		return list;

	}

	public int updateEmployee(Employee employee) {

		// define query

		String updateSQL = "update employee set name=?,salary =? where id=?";

		System.out.println("jdbcTemplate is:" + jdbcTemplate);

		int row = jdbcTemplate.update(updateSQL,
				new Object[] { employee.getName(), employee.getSalary(), employee.getId() });

		return row;

	}

	public int deleteEmployee(int id) {

		String deleteSQL = "delete from employee where id=" + id;

		return jdbcTemplate.update(deleteSQL);

	}
	

	public List readEmployeesByName(String name) {

		String readQuery = "select * from employee where name = '"+name+"'";
		// String readQuery = "select * from employee";

		List list = jdbcTemplate.queryForList(readQuery);

		return list;

	}

}

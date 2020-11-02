package com.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	// private NamedParameterJDBCTemplate npJdbcTemplate;

	public List<Employee> readEmployees() {

		String readQuery = "select * from employee";
		// String readQuery = "select * from employee";

		return jdbcTemplate.query(readQuery, new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				Employee employee = new Employee();

				employee.setId(rs.getInt("id"));

				employee.setName(rs.getString("name"));

				employee.setSalary(rs.getFloat("salary"));

				return employee;
			}
		});

	}

	public List<Employee> readEmployeesByRSE() {

		String readQuery = "select * from employee";
		// String readQuery = "select * from employee";

		return jdbcTemplate.query(readQuery, new ResultSetExtractor<List<Employee>>() {

			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Employee> list = new ArrayList<Employee>();

				while (rs.next()) {
					Employee employee = new Employee();

					employee.setId(rs.getInt("id"));

					employee.setName(rs.getString("name"));

					employee.setSalary(rs.getFloat("salary"));

					if (employee.getId() > 100) {

						list.add(employee);
					}
				}
				return list;
			}
		});

	}

}

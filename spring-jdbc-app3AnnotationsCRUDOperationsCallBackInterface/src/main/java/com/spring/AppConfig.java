package com.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springtest");
		dataSource.setUsername("root");
		dataSource.setPassword("Subbarao1516");

		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());

		return jdbcTemplate;

	}

	@Bean
	public EmployeeDAO employeeDAO() {

		EmployeeDAO employeeDAO = new EmployeeDAO();

		return employeeDAO;

	}

}

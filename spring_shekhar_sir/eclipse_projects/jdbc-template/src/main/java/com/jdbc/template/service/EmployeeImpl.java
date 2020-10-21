package com.jdbc.template.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.template.dao.EmployeeDao;

@Repository
public class EmployeeImpl implements EmployeeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Map<String, Object>> getAllEmployees() {
		
		return jdbcTemplate.queryForList("select * from emp");
		
	}

}

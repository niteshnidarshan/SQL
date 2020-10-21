package com.jdbc.template.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
	public List<Map<String, Object>> getAllEmployees();
}

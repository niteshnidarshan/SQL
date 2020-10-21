package com.jdbc.template.runner;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jdbc.template.dao.EmployeeDao;
@Component
public class MyRunner implements CommandLineRunner{
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public void run(String... args) throws Exception {
		List<Map<String, Object>> list = dao.getAllEmployees();
		//list.forEach(System.out::println);
		list.forEach(emp->{
			emp.forEach((key,val) -> {
				System.out.println(key+" | "+val);
			});
			System.out.println("-------------------");
		});
	}

}

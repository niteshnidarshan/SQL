package com.oto.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.oto.entity.Passport;
import com.oto.entity.Person;
import com.oto.repository.PassportRepository;

@Component
public class MyRunner implements CommandLineRunner {
	
	@Autowired
	PassportRepository  repo;

	@Override
	public void run(String... args) throws Exception {
		Person  person=new Person();
		person.setPersonId(101);
		person.setPersonName("ANIL");
		
		Passport  passport=new  Passport();
		passport.setExpDate(LocalDate.of(2025, 12, 31));
		passport.setPerson(person);
		
		repo.save(passport);
		
	}

}

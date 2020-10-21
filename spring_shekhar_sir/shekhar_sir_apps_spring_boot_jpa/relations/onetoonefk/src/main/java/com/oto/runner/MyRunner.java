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
		
		/*
		Passport  passport=new  Passport();
		passport.setPassportNo(11231);
		passport.setExpDate(LocalDate.of(2025, 12, 31));
		passport.setPerson(person);
		*/
		
		Passport  new_passport=new  Passport();
		new_passport.setPassportNo(53119);
		new_passport.setExpDate(LocalDate.of(2021, 3, 31));
		new_passport.setPerson(person);
		repo.save(new_passport);
		
	}

}

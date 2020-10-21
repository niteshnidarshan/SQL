package com.oto.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passport {
	@GenericGenerator(name="g1", strategy="foreign", parameters=@Parameter(name="property", value="person"))
	
	@Id
	@GeneratedValue(generator="g1")
	private Integer  passportNo;
	
	private LocalDate  expDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private  Person  person;

}

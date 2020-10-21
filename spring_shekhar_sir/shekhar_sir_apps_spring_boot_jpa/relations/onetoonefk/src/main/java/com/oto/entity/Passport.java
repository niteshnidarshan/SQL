package com.oto.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passport {
	@Id
	private Integer  passportNo;
	
	private LocalDate  expDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PERSONID_FK", unique=true)
	private  Person  person;

}

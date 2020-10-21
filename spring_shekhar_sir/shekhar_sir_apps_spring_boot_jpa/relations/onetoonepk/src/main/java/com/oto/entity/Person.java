package com.oto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {
	@Id
	private Integer personId;
	
	@Column(length=10)
	private String personName;
	
	
	

}

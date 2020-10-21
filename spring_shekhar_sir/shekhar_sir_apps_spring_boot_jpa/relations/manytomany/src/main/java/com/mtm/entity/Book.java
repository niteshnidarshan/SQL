package com.mtm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
	@Id
	private Integer  bookid;
	
	@Column(length=10)
	private String  bookname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="BOOKS_AUTHORS", joinColumns=@JoinColumn(name="BOOKID_FK"), inverseJoinColumns=@JoinColumn(name="AUTHORID_FK"))
	private  List<Author>  authors;
	

}

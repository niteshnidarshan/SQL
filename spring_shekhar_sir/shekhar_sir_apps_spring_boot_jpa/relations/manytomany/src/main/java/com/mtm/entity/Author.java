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
public class Author {
	@Id
	private  Integer  authorid;
	
	@Column(length=12)
	private  String  authorname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="BOOKS_AUTHORS", joinColumns=@JoinColumn(name="AUTHORID_FK"), inverseJoinColumns=@JoinColumn(name="BOOKID_FK"))
	private  List<Book>  books;

}

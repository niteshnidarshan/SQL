package com.mtm.runner;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mtm.entity.Author;
import com.mtm.entity.Book;
import com.mtm.repository.AuthorRepository;
import com.mtm.repository.BookRepository;
@Component
public class MyRunner implements CommandLineRunner {
	@Autowired
	BookRepository  bookRepo;
	
	@Autowired
	AuthorRepository  authorRepo;
	

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		/*
		Book  b1=new Book();
		b1.setBookid(1);  b1.setBookname("Java");
		
		Author a1=new Author();
		a1.setAuthorid(91); a1.setAuthorname("A");
		Author a2=new Author();
		a2.setAuthorid(92); a2.setAuthorname("B");
		
		List<Author>  authorsList =new  ArrayList<>();
		authorsList.add(a1); authorsList.add(a2);
		
		b1.setAuthors(authorsList);
		
		Book b2=new Book();
		b2.setBookid(2);  b2.setBookname("Spring");
		Book b3=new Book();
		b3.setBookid(3);  b3.setBookname("Oracle");
		List<Book>  booksList =new  ArrayList<>();
		booksList.add(b2);
		booksList.add(b3);
		a2.setBooks(booksList);
		
		bookRepo.save(b1);
		*/
		
		/*
		 * add a new author to a book
		 */
		Author  new_author=new  Author();
		new_author.setAuthorid(93);  new_author.setAuthorname("C");
		
		Book  b = bookRepo.findById(1).get();
		List<Author>  authList=b.getAuthors();
		authList.add(new_author);
		
		
		

	}

}

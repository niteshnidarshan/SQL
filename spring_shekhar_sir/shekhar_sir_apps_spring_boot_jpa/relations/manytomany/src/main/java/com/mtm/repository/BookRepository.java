package com.mtm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtm.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}

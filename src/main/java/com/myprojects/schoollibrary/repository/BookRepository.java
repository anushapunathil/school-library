package com.myprojects.schoollibrary.repository;

import com.myprojects.schoollibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.myprojects.schoollibrary;

import com.myprojects.schoollibrary.model.Book;
import com.myprojects.schoollibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolLibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SchoolLibraryApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		//Code here
	}
}

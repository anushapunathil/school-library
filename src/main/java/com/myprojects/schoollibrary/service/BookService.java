package com.myprojects.schoollibrary.service;

import com.myprojects.schoollibrary.dto.BookRequest;
import com.myprojects.schoollibrary.model.Book;
import com.myprojects.schoollibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    public void addBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setISBN(bookRequest.getISBN());
        book.setGenre(bookRequest.getGenre());
        book.setPublicationDate(bookRequest.getPublicationDate());
        book.setAvailable(true);
        bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}

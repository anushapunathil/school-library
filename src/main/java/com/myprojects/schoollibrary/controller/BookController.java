package com.myprojects.schoollibrary.controller;

import com.myprojects.schoollibrary.dto.BookRequest;
import com.myprojects.schoollibrary.model.Book;
import com.myprojects.schoollibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

@Controller
//@RestController
//@RequestMapping("/api/add-book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addBook(@RequestBody BookRequest bookRequest) {
        bookService.addBook(bookRequest);
        return "Book added successfully";
    }

    @GetMapping("/books")
    public String listAllBooks(Model model) {
        model.addAttribute("books",bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/books/new")
    public String createBookForm(Model model) {

        //Create book object to hold book form data
        Book book = new Book();
        model.addAttribute("book",book);
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book",bookService.getBookById(id));
        return "edit_book";
    }
    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Long id,
    @ModelAttribute("book") Book book,
    Model model){
        //Get book from database by id
        Book existingBook = bookService.getBookById(id);
        existingBook.setId(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setISBN(book.getISBN());
        existingBook.setGenre(book.getGenre());
        existingBook.setPublicationDate(book.getPublicationDate());
        existingBook.setAvailable(book.isAvailable());
        bookService.updateBook(existingBook);
        return "redirect:/books";
    }

    //handler method to handle delete book request
    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

}

package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookTitle) {
        bookRepository.save(bookTitle);
    }

    public void listBooks() {
        System.out.println("Books: " + bookRepository.findAll());
    }
}

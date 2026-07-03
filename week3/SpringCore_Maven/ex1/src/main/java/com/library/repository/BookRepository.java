package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private final List<String> books = new ArrayList<>();

    public void save(String bookTitle) {
        books.add(bookTitle);
        System.out.println("Book saved to repository: " + bookTitle);
    }

    public List<String> findAll() {
        return books;
    }
}

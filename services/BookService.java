package services;

import model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> findAll();
}

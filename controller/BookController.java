package controller;

import model.Book;
import services.BookServiceImpl;

import java.util.List;

public class BookController {
    private final BookServiceImpl bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    public Book addBook(Book book) {
        return bookServiceImpl.addBook(book);
    }

    public List<Book> listAll() {
        return bookServiceImpl.findAll();
    }


}

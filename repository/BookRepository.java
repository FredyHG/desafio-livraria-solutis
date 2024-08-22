package repository;

import model.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List<Book> getBooks();
}

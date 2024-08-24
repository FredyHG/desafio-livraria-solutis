package repository;

import model.Book;
import model.Printed;

import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List<Book> getBooks();

    Book getByTitle(String title);

    Book getById(String id);

    void updateStock(List<Printed> booksToUpdate);
}

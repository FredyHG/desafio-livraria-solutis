package repository;

import model.Book;
import model.Electronic;
import model.Printed;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private static List<Book> books = new ArrayList<>();

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getByTitle(String title) {
        return books.stream().
                filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Book getById(String id) {
        return books.stream().
                filter(book -> book.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateStock(List<Printed> booksToUpdate) {
      //  System.out.println("Quantidade antiga => " + books.toString());
        for (Printed book: booksToUpdate) {
            Printed newBook = book;
            newBook.setStock(book.getStock() - 1);
            books.remove(book);
            books.add(newBook);
        }
       // System.out.println("Quantidade nova => " + books.toString());
    }
}
package services;

import model.Book;
import model.Electronic;
import model.Printed;
import repository.BookRepository;

import java.util.List;

public class BookServiceImpl {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Electronic> getAllElectronics() {
        //IMPLEMENTAR
        return null;
    }

    public List<Printed> getAllPrinted() {
        //IMPLEMENTAR
        return null;
    }

    public List<Book> findAll() {
        return bookRepository.getBooks();
    }
}

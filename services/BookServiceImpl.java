package services;

import model.Book;
import model.Electronic;
import model.Printed;
import model.Sale;
import repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Electronic> getAllElectronics() {
        // Implementar

        return null;
    }

    public List<Printed> getAllPrinted() {
        // Implementar

        return null;
    }

    public List<Book> findAll() {
        return bookRepository.getBooks();
    }

    public Book getByTitle(String title) {
        return bookRepository.getByTitle(title);
    }

    public Book getById(String id) {
        return bookRepository.getById(id);
    }

    public void updateStock(Sale sale){
        List<Printed> booksToUpdate = sale.getBooks().stream().
                                        filter(Printed.class::isInstance)
                                        .map(Printed.class::cast)
                                        .collect(Collectors.toList());

        bookRepository.updateStock(booksToUpdate);
    }
}

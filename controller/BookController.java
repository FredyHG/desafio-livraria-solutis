package controller;

import model.Book;
import model.Printed;
import model.Sale;
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

    public List<?> listByType(String type){
        switch (type.toUpperCase()){
            case "D":
                return bookServiceImpl.getAllElectronics();
            case "F":
                return bookServiceImpl.getAllPrinted();
            default:
                return null;
        }
    }

    public Book getByTitle(String title){
        return bookServiceImpl.getByTitle(title);
    }

    public Book getById(String id){
        return bookServiceImpl.getById(id);
    }

    public void updateStock(Sale sale){
        bookServiceImpl.updateStock(sale);
    }
}

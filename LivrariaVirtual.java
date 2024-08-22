
import controller.BookController;
import factory.BookFactory;
import model.Book;
import model.Electronic;
import model.Printed;
import repository.BookRepositoryImpl;
import services.BookServiceImpl;
import utils.InputHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class LivrariaVirtual {

    public static void main(String[] args) {

    }

    public static void panel() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl(bookRepository);
        BookController bookController = new BookController(bookServiceImpl);

        //Implementar painel
        //chamar os metodos de controller

        BookFactory.createElectronic(null, null, null, null, null); //example factory
    }

    public void registerBook() {
        Scanner sc = new Scanner(System.in);

        try (sc) {
            InputHandler inputHandler = new InputHandler(sc);
            String title = inputHandler.getBookTitle();
            double price = inputHandler.getBookPrice();
            String publisher = inputHandler.getBookPublisher();
            List<String> authors = inputHandler.getBookAuthors();
            String type = inputHandler.getBookType();

            if (type.equalsIgnoreCase("D")) {
                int size = inputHandler.getBookSize();
                BookFactory.createElectronic(title, price, publisher, authors, size);
            } else {
                float freight = inputHandler.getBookFreight();
                int stock = inputHandler.getBookStock();
                BookFactory.createPrinted(title, price, publisher, authors, freight, stock);
            }

            System.out.println("Livro registrado com sucesso!");

        } catch (Exception e) {
            System.out.println(STR."Ocorreu um erro: \{e.getMessage()}");
        }
    }

}


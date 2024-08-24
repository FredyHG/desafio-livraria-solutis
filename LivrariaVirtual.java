
import controller.BookController;
import factory.BookFactory;
import model.Electronic;
import model.Printed;
import repository.BookRepositoryImpl;
import services.BookServiceImpl;
import utils.InputHandler;
import java.util.List;
import java.util.Scanner;


public class LivrariaVirtual {

    private static final int MAX_PRINTED = 10;
    private static final int MAX_ELECTRONIC = 20;

    public static void main(String[] args) {
        registerBook();
    }

    public static void panel() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl(bookRepository);
        BookController bookController = new BookController(bookServiceImpl);

        //Implementar painel
        //chamar os metodos de controller

        BookFactory.createElectronic(null, null, null, null, null); //example factory
    }

    public static BookController createBookController() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl(bookRepository);
        return new BookController(bookServiceImpl);
    }

    public static int countDigitalBooks() {
        BookController bookController = createBookController();
        return (int) bookController.listAll().stream()
                .filter(book -> book instanceof Electronic)
                .count();
    }

    public static int countPhysicalBooks() {
        BookController bookController = createBookController();
        return (int) bookController.listAll().stream()
                .filter(book -> book instanceof Printed)
                .count();
    }

    public static void registerBook() {
        BookController bookController = createBookController();
        Scanner sc = new Scanner(System.in);

        try (sc) {
            InputHandler inputHandler = new InputHandler(sc);
            String title = inputHandler.getBookTitle();
            double price = inputHandler.getBookPrice();
            String publisher = inputHandler.getBookPublisher();
            List<String> authors = inputHandler.getBookAuthors();
            String type = inputHandler.getBookType();

            if (type.equalsIgnoreCase("D")) {
                registerDigitalBook(bookController, inputHandler, title, price, publisher, authors);
            } else {
                registerPrintedBook(bookController, inputHandler, title, price, publisher, authors);
            }

            System.out.println("Livro registrado com sucesso!");

        } catch (Exception e) {
            System.out.println(STR."Ocorreu um erro: \{e.getMessage()}");
        }
    }

    private static void registerPrintedBook(BookController bookController, InputHandler inputHandler,
                                            String title, double price, String publisher, List<String> authors) {
        if (countPhysicalBooks() >= MAX_PRINTED) {
            System.out.println("Limite de cadastros atingido para livros físicos.");
        } else {
            float freight = inputHandler.getBookFreight();
            int stock = inputHandler.getBookStock();
            Printed printed = BookFactory.createPrinted(title, price, publisher, authors, freight, stock);
            bookController.addBook(printed);
        }
    }

    private static void registerDigitalBook(BookController bookController, InputHandler inputHandler,
                                            String title, double price, String publisher, List<String> authors) {
        if (countDigitalBooks() >= MAX_ELECTRONIC) {
            System.out.println("Limite de cadastros atingido para livros digitais.");
        } else {
            int size = inputHandler.getBookSize();
            Electronic electronic = BookFactory.createElectronic(title, price, publisher, authors, size);
            bookController.addBook(electronic);
        }

    }

}


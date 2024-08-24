
import controller.BookController;
import controller.SaleController;
import factory.BookFactory;
import model.Book;
import model.Electronic;
import model.Printed;
import model.Sale;
import repository.BookRepositoryImpl;
import repository.SaleRepositoryImpl;
import services.BookServiceImpl;
import services.SaleServiceImpl;
import utils.InputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class LivrariaVirtual {

    private static final int MAX_PRINTED = 10;
    private static final int MAX_ELECTRONIC = 20;

    public static void main(String[] args) {
        registerBook();
        makeSale();
        getSales();
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

    private static SaleController createSaleController() {
        SaleRepositoryImpl saleRepository = new SaleRepositoryImpl();
        SaleServiceImpl saleServiceImpl = new SaleServiceImpl(saleRepository);
        return new SaleController(saleServiceImpl);
    }

    private static void makeSale(){
        BookController bookController = createBookController();
        SaleController saleController = createSaleController();

        //###################################### MOCK ######################################
        Electronic electronic = BookFactory.createElectronic("livro-eletronico", 10.0, "publisher-eletronico", Arrays.asList("A", "B", "C"), 12);
        bookController.addBook(electronic);
        Printed printed = BookFactory.createPrinted("livro-fisico", 20.0, "publisher-fisico", Arrays.asList("d", "e", "f"), 10f, 2);
        bookController.addBook(printed);
        Electronic electronic1 = BookFactory.createElectronic("Jogador Numero 1", 10.0, "publisher-eletronico", Arrays.asList("A", "B", "C"), 12);
        bookController.addBook(electronic1);
        Printed printed1 = BookFactory.createPrinted("Jogador Numero 1", 20.0, "publisher-fisico", Arrays.asList("d", "e", "f"), 10f, 2);
        bookController.addBook(printed1);
        //###################################### MOCK ######################################

        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {
            InputHandler inputHandler = new InputHandler(sc);
            String customerName = inputHandler.getCustomerName();
            Integer numberOfBooksToBuy = inputHandler.getNumberOfBooksToBuy();

            for (int i = 0; i < numberOfBooksToBuy; i++) {
               String typoOfBook = inputHandler.getBookType();
               System.out.println(bookController.listByType(typoOfBook));
               String selectedBook = inputHandler.getSelectedBook();
//               books.add(bookController.getByTitle(selectedBook));
                books.add(bookController.getById(selectedBook));
            }

            Sale sale = new Sale(books, customerName);
            System.out.println("\nVenda concluida com sucesso");
            System.out.println();
            System.out.println(saleController.makeSale(sale));

            bookController.updateStock(sale);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getSales(){
        SaleController saleController = createSaleController();

        saleController.getAll().forEach(System.out::println);
    }
}


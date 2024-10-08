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


public class LivrariaVirtual {

    private static final int MAX_PRINTED = 10;
    private static final int MAX_ELECTRONIC = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        panel();

    }

    public static void panel() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Realizar Venda");
            System.out.println("3. Listar Livros");
            System.out.println("4. Listar Vendas");
            System.out.println("5. Sair");

            String opcaoPrincipal = scanner.nextLine();

            switch (opcaoPrincipal) {
                case "1":
                    registerBook();
                    break;
                case "2":
                    makeSale();
                    break;
                case "3":
                    listBooks(scanner);
                    break;
                case "4":
                    getSales();
                    break;
                case "5":
                    System.out.println("Saindo... \n\nAutores: Pietra, Maria Eduarda, Renato, Fredy, Syllas, Luiz Carlos.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }

    }

    public static void listBooks(Scanner scanner) {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl(bookRepository);
        BookController bookController = new BookController(bookServiceImpl);
        Scanner sc = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(sc);

        while (true) {
            System.out.println("============================");
            System.out.println("     Sistema de Livraria     ");
            System.out.println("       - Listar Livros -     ");
            System.out.println("============================");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Listar todos os livros");
            System.out.println("2. Listar livros digitais");
            System.out.println("3. Listar livros físicos");
            System.out.println("4. Sair");
            System.out.println("============================");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    List<Book> allBooks = bookController.listAll();
                    System.out.println("Todos os Livros:");
                    allBooks.forEach(System.out::println);
                    break;

                case 2:
                    List<?> electronicBooks = bookController.listByType("D");
                    System.out.println("Livros Digitais:");
                    electronicBooks.forEach(System.out::println);
                    break;

                case 3:
                    List<?> printedBooks = bookController.listByType("F");
                    System.out.println("Livros Físicos:");
                    printedBooks.forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida, por favor tente novamente.");
            }
            break;
        }
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

    private static void makeSale() {
        BookController bookController = createBookController();
        SaleController saleController = createSaleController();
        mockData();
        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(sc);
        String customerName = inputHandler.getCustomerName();
        Integer numberOfBooksToBuy = inputHandler.getNumberOfBooksToBuy();

        for (int i = 0; i < numberOfBooksToBuy; i++) {
            String typoOfBook = inputHandler.getBookType();
            System.out.println(bookController.listByType(typoOfBook));
            String selectedBook = inputHandler.getSelectedBook(createBookController().listAll());
            //books.add(bookController.getByTitle(selectedBook));
            books.add(bookController.getById(selectedBook));
        }

        Sale sale = new Sale(books, customerName);
        System.out.println("\nVenda concluida com sucesso");
        System.out.println();
        System.out.println(saleController.makeSale(sale));

        bookController.updateStock(sale);
    }

    private static void getSales() {
        SaleController saleController = createSaleController();

        saleController.getAll().forEach(System.out::println);
    }

    private static void  mockData(){
        BookController bookController = createBookController();
        Electronic electronic = BookFactory.createElectronic("livro-eletronico", 10.0, "publisher-eletronico", Arrays.asList("A", "B", "C"), 12);
        bookController.addBook(electronic);
        Printed printed = BookFactory.createPrinted("livro-fisico", 20.0, "publisher-fisico", Arrays.asList("d", "e", "f"), 10f, 2);
        bookController.addBook(printed);
        Electronic electronic1 = BookFactory.createElectronic("Jogador Numero 1", 10.0, "publisher-eletronico", Arrays.asList("A", "B", "C"), 12);
        bookController.addBook(electronic1);
        Printed printed1 = BookFactory.createPrinted("Jogador Numero 1", 20.0, "publisher-fisico", Arrays.asList("d", "e", "f"), 10f, 2);
        bookController.addBook(printed1);
    }

}


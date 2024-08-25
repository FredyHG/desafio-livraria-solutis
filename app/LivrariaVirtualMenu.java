package app;

import javax.swing.JOptionPane;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LivrariaVirtualMenu {

    private static final int MAX_PRINTED = 10;
    private static final int MAX_ELECTRONIC = 20;

    public static void main(String[] args) {
        while (true) {
            String[] opcoes = {"Registrar Livro", "Fazer Venda", "Visualizar Vendas", "Sair"};
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Menu Livraria Virtual",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0:
                    registerBook();
                    break;
                case 1:
                    makeSale();
                    break;
                case 2:
                    getSales();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    public static void registerBook() {
        BookController bookController = createBookController();
        String title = JOptionPane.showInputDialog("Digite o título do livro:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do livro:"));
        String publisher = JOptionPane.showInputDialog("Digite a editora do livro:");
        String authorsInput = JOptionPane.showInputDialog("Digite os autores (separados por vírgula):");
        List<String> authors = Arrays.asList(authorsInput.split(","));
        String type = JOptionPane.showInputDialog("Digite o tipo do livro (D para Digital, P para Físico):");

        if (type.equalsIgnoreCase("D")) {
            registerDigitalBook(bookController, title, price, publisher, authors);
        } else {
            registerPrintedBook(bookController, title, price, publisher, authors);
        }

        JOptionPane.showMessageDialog(null, "Livro registrado com sucesso!");
    }

    private static void registerPrintedBook(BookController bookController,
                                            String title, double price, String publisher, List<String> authors) {
        if (countPhysicalBooks() >= MAX_PRINTED) {
            JOptionPane.showMessageDialog(null, "Limite de cadastros atingido para livros físicos.");
        } else {
            float freight = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do frete:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque do livro:"));
            Printed printed = BookFactory.createPrinted(title, price, publisher, authors, freight, stock);
            bookController.addBook(printed);
        }
    }

    private static void registerDigitalBook(BookController bookController,
                                            String title, double price, String publisher, List<String> authors) {
        if (countDigitalBooks() >= MAX_ELECTRONIC) {
            JOptionPane.showMessageDialog(null, "Limite de cadastros atingido para livros digitais.");
        } else {
            int size = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do arquivo (MB):"));
            Electronic electronic = BookFactory.createElectronic(title, price, publisher, authors, size);
            bookController.addBook(electronic);
        }
    }

    private static void makeSale() {
        BookController bookController = createBookController();
        SaleController saleController = createSaleController();

        String customerName = JOptionPane.showInputDialog("Digite o nome do cliente:");
        int numberOfBooksToBuy = Integer.parseInt(JOptionPane.showInputDialog("Quantos livros deseja comprar?"));

        ArrayList<Book> books = new ArrayList<>();

        for (int i = 0; i < numberOfBooksToBuy; i++) {
            String bookType = JOptionPane.showInputDialog("Digite o tipo do livro (D para Digital, P para Físico):");
            List<Book> availableBooks = (List<Book>) bookController.listByType(bookType);
            String bookList = "Livros disponíveis:\n";
            for (int j = 0; j < availableBooks.size(); j++) {
                bookList += j + 1 + ". " + availableBooks.get(j).getTitle() + "\n";
            }
            int bookChoice = Integer.parseInt(JOptionPane.showInputDialog(bookList + "Escolha o número do livro:")) - 1;
            books.add(availableBooks.get(bookChoice));
        }

        Sale sale = new Sale(books, customerName);
        JOptionPane.showMessageDialog(null, "Venda concluída com sucesso!");
        saleController.makeSale(sale);
        bookController.updateStock(sale);
    }

    private static void getSales() {
        SaleController saleController = createSaleController();
        StringBuilder salesList = new StringBuilder("Vendas realizadas:\n");
        for (Sale sale : saleController.getAll()) {
            salesList.append(sale.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, salesList.toString());
    }

    private static BookController createBookController() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl(bookRepository);
        return new BookController(bookServiceImpl);
    }

    private static SaleController createSaleController() {
        SaleRepositoryImpl saleRepository = new SaleRepositoryImpl();
        SaleServiceImpl saleServiceImpl = new SaleServiceImpl(saleRepository);
        return new SaleController(saleServiceImpl);
    }

    private static int countDigitalBooks() {
        BookController bookController = createBookController();
        return (int) bookController.listAll().stream()
                .filter(book -> book instanceof Electronic)
                .count();
    }

    private static int countPhysicalBooks() {
        BookController bookController = createBookController();
        return (int) bookController.listAll().stream()
                .filter(book -> book instanceof Printed)
                .count();
    }
}


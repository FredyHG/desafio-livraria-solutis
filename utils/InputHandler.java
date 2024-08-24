package utils;

import model.Book;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class InputHandler {
    private final Scanner sc;

    public InputHandler(Scanner sc) {
        this.sc = sc;
    }

    public String getBookTitle() {
        System.out.print("Insira o título do livro: ");
        String title = sc.nextLine();
        if (title.isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        return title;
    }

    public double getBookPrice() {
        System.out.print("Insira o valor do livro: ");
        while (true) {
            try {
                double price = sc.nextDouble();
                if (price <= 0) {
                    throw new IllegalArgumentException("O valor do livro não pode ser negativo.");
                }
                return price;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o preço.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public String getBookPublisher() {
        System.out.print("Insira a editora do livro: ");
        sc.nextLine();
        String publisher = sc.nextLine();
        if (publisher.isEmpty()) {
            throw new IllegalArgumentException("A editora não pode ser vazia.");
        }
        return publisher;
    }

    public List<String> getBookAuthors() {
        List<String> authors = new ArrayList<>();
        String anotherAuthor;

        do {
            System.out.print("Insira o autor do livro: ");
            String author = sc.nextLine();
            if (author.isEmpty()) {
                System.out.print("O nome do autor não pode ser vazio.");
            } else {
                authors.add(author);
            }

            System.out.print("Deseja inserir mais um autor? (S/N) ");
            anotherAuthor = sc.nextLine();

        } while (anotherAuthor.equalsIgnoreCase("S"));

        if (authors.isEmpty()) {
            throw new IllegalArgumentException("Pelo menos um autor deve ser inserido.");
        }

        return authors;
    }

    public String getBookType() {
        System.out.print("O livro é digital ou físico? (D/F) ");
        while (true) {
            String type = sc.nextLine();
            if (type.equalsIgnoreCase("D") || type.equalsIgnoreCase("F")) {
                return type;
            } else {
                System.out.print("Por favor, insira 'D' para digital ou 'F' para físico.");
            }
        }
    }

    public int getBookSize() {
        System.out.print("Insira o tamanho do livro: ");
        while (true) {
            try {
                int size = sc.nextInt();
                if (size <= 0) {
                    throw new IllegalArgumentException("O tamanho do livro deve ser maior que zero.");
                }
                return size;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o tamanho.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public float getBookFreight() {
        System.out.print("Insira o valor do frete: ");
        while (true) {
            try {
                float freight = sc.nextFloat();
                if (freight < 0) {
                    throw new IllegalArgumentException("O valor do frete não pode ser negativo.");
                }
                return freight;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o frete.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public int getBookStock() {
        System.out.print("Insira o número do estoque: ");
        while (true) {
            try {
                int stock = sc.nextInt();
                if (stock < 0) {
                    throw new IllegalArgumentException("O número do estoque não pode ser negativo.");
                }
                return stock;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o estoque.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public String getCustomerName() {
        System.out.print("Insira o nome do cliente: ");
        String customerName = sc.nextLine();
        if (customerName.isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        return customerName;
    }

    public int getNumberOfBooksToBuy() {
        System.out.print("Insira o número de livros que deseja comprar: ");
        while (true) {
            try {
                int numbers = sc.nextInt();
                if (numbers < 0) {
                    throw new IllegalArgumentException("O número de livros não pode ser negativo.");
                }
                return numbers;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para a quantidade de livros.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public String getSelectedBook(List<Book> books) {
        String bookId = null;

        // Continua solicitando um ID válido até que o usuário insira corretamente
        while (true) {
            System.out.print("Insira o id do livro que deseja comprar: ");
            bookId = sc.nextLine();

            if (bookId.isEmpty()) {
                System.out.println("O id do livro não pode ser vazio.");
                continue;  // Repete a solicitação do ID
            }

            boolean found = false;
            for (Book book : books) {
                if (book.getId().equals(bookId)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                return bookId;  // ID válido encontrado, retorna o ID
            } else {
                System.out.println("Livro com o ID fornecido não foi encontrado. Tente novamente.");
            }
        }
    }
}

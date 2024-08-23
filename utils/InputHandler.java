package utils;

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
        while(true){
            System.out.print("Insira o título do livro: ");
            String title = sc.nextLine();
            if (!title.isEmpty()) {
                return title;
            }else{
                System.out.println("O título não pode ser vazio.");
            }
        }
    }

    public double getBookPrice() {
        while (true) {
            try {
                System.out.print("Insira o valor do livro: ");
                double price = sc.nextDouble();
                if (price <= 0) {
                    throw new IllegalArgumentException("O valor do livro não pode ser negativo. \n");
                }
                return price;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o preço. \n");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public String getBookPublisher() {
        sc.nextLine();
        while(true){
            System.out.print("Insira a editora do livro: ");
            String publisher = sc.nextLine();
            if (!publisher.isEmpty()) {
                return publisher;
            } else {
                System.out.println("A editora não pode ser vazia.");
            }
        }
    }

    public List<String> getBookAuthors() {
        List<String> authors = new ArrayList<>();
        String anotherAuthor;

        do {
            do{
                System.out.print("Insira o autor do livro: ");
                String author = sc.nextLine();
                if (author.isEmpty()) {
                    System.out.print("O nome do autor não pode ser vazio. \n");
                } else {
                    authors.add(author);
                }
            }while(authors.isEmpty());

            System.out.print("Deseja inserir mais um autor? (S/N) ");
            anotherAuthor = sc.nextLine();

        } while (anotherAuthor.equalsIgnoreCase("S"));

        return authors;
    }

    public String getBookType() {
        while (true) {
            System.out.print("O livro é digital ou físico? (D/F) ");
            String type = sc.nextLine();
            if (type.equalsIgnoreCase("D") || type.equalsIgnoreCase("F")) {
                return type;
            } else {
                System.out.print("Por favor, insira 'D' para digital ou 'F' para físico. \n");
            }
        }
    }

    public int getBookSize() {
        while (true) {
            try {
                System.out.print("Insira o tamanho do livro: ");
                int size = sc.nextInt();
                if (size <= 0) {
                    throw new IllegalArgumentException("O tamanho do livro deve ser maior que zero. \n");
                }
                return size;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o tamanho. \n");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public float getBookFreight() {
        while (true) {
            try {
                System.out.print("Insira o valor do frete: ");
                float freight = sc.nextFloat();
                if (freight < 0) {
                    throw new IllegalArgumentException("O valor do frete não pode ser negativo.\n ");
                }
                return freight;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o frete.\n");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public int getBookStock() {
        while (true) {
            try {
                System.out.print("Insira o número do estoque: ");
                int stock = sc.nextInt();
                if (stock < 0) {
                    throw new IllegalArgumentException("O número do estoque não pode ser negativo. \n");
                }
                return stock;
            } catch (InputMismatchException e) {
                System.out.print("Por favor, insira um número válido para o estoque. \n");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }
}

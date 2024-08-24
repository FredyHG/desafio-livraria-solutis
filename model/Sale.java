package model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Sale {
    private String id;
    private ArrayList<Book> books;
    private String clientName;
    private Integer number;
    private Double price;

    public Sale(ArrayList<Book> books, String clientName) {
        this.id = UUID.randomUUID().toString();
        this.books = books;
        this.clientName = clientName;
        this.number = ThreadLocalRandom.current().nextInt(1, 100 + 1);;
        this.price = calcPrice(books);
    }

    private static double calcPrice(ArrayList<Book> books){
        double totalElectronicPrice = books.stream()
                .filter(Electronic.class::isInstance)
                .map(Electronic.class::cast)
                .mapToDouble(Electronic::getPrice)
                .sum();

        double totalPrintedCost = books.stream()
                .filter(Printed.class::isInstance)
                .map(Printed.class::cast)
                .mapToDouble(printed -> printed.getPrice() + printed.getFreight())
                .sum();

        return totalElectronicPrice + totalPrintedCost;
    }

    public Sale() {
    }

    @Override
    public String toString() {
        String formattedBooks = books.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        return "🛒 Detalhes da Venda:\n" +
                "-----------------------------------\n" +
                "🔖 ID da Venda: " + id + "\n" +
                "📚 Livros: " + formattedBooks + "\n" +
                "👤 Cliente: " + clientName + "\n" +
                "📞 Número: " + number + "\n" +
                "💲 Preço Total: R$ " + price + "\n" +
                "-----------------------------------";
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

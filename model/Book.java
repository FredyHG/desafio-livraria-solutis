package model;

import java.util.List;
import java.util.UUID;

public abstract class Book {
    private String id;
    private String title;
    private List<String> author;
    private String publisher;
    private Double price;


    public Book(String title, Double price, String publisher, List<String> author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.price = price;
        this.publisher = publisher;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id='" + id + '\'' +
                "titulo='" + title + '\'' +
                ", autores=" + author +
                ", editora='" + publisher + '\'' +
                ", preco=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

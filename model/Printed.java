package model;

import java.util.List;

public class Printed extends Book {

    private Float freight;
    private Integer stock;

    public Printed(String title, Double price, String publisher, List<String> authors, Float freight, Integer stock) {
        super(title, price, publisher, authors);
        this.freight = freight;
        this.stock = stock;
    }

    public Float getFreight() {
        return freight;
    }

    public void setFreight(Float freight) {
        this.freight = freight;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void updateStock() {
        this.stock = this.stock + 1;
    }

    @Override
    public String toString() {
        return "Impresso {" +
                "titulo='" + getTitle() + '\'' +
                ", autores=" + getAuthor() +
                ", editora='" + getPublisher() + '\'' +
                ", preco=" + getPrice() +
                ", frete=" + getFreight() +
                ", estoque=" + getStock() +
                '}';
    }
}

package model;

import java.util.List;

public class Electronic extends Book {

    private Integer size;

    public Electronic(String title, double price, String publisher, List<String> author, Integer size) {
        super(title, price, publisher, author);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Eletronico {" +
                "titulo='" + getTitle() + '\'' +
                ", autores=" + getAuthor() +
                ", editora='" + getPublisher() + '\'' +
                ", preco=" + getPrice() +
                ", tamanho=" + getSize() +
                '}';
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

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
        return "\n📚 Detalhes do Livro Impresso:\n" +
                "-----------------------------------\n" +
                "🔖 ID: " + getId() + "\n" +
                "📖 Título: " + getTitle() + "\n" +
                "👤 Autor(es): " + getAuthor() + "\n" +
                "🏢 Editora: " + getPublisher() + "\n" +
                "💲 Preço: R$ " + getPrice() + "\n" +
                "🚚 Frete: R$ " + getFreight() + "\n" +
                "📦 Estoque: " + getStock() + " unidades\n" +
                "-----------------------------------\n";
    }
}

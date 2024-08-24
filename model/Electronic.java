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
        return "\n📚 Detalhes do Livro Eletrônico:\n" +
                "-----------------------------------\n" +
                "🔖 ID: " + getId() + "\n" +
                "📖 Título: " + getTitle() + "\n" +
                "👤 Autor(es): " + getAuthor() + "\n" +
                "🏢 Editora: " + getPublisher() + "\n" +
                "💲 Preço: R$ " + getPrice() + "\n" +
                "📏 Tamanho: " + getSize() + " MB\n" +
                "-----------------------------------\n";
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

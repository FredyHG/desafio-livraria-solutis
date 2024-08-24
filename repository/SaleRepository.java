package repository;

import model.Sale;

import java.util.List;

public interface SaleRepository {
    Sale save(Sale sale);
    List<Sale> getAll();
}

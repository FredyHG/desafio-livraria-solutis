package services;

import model.Sale;

import java.util.List;

public interface SaleService {
    Sale makeSale(Sale sale);
    List<Sale> getAll();
}

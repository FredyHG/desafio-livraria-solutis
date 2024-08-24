package repository;

import model.Sale;

import java.util.ArrayList;
import java.util.List;

public class SaleRepositoryImpl implements SaleRepository{

    private static List<Sale> sales = new ArrayList<>();

    @Override
    public Sale save(Sale sale) {
        sales.add(sale);
        return sale;
    }

    @Override
    public List<Sale> getAll() {
        return sales;
    }
}

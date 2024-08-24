package services;

import model.Sale;
import repository.SaleRepository;

import java.util.List;

public class SaleServiceImpl implements SaleService{

    private final SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale makeSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.getAll();
    }
}

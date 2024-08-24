package services;

import model.Sale;
import repository.SaleRepository;

public class SaleServiceImpl implements SaleService{

    private SaleRepository saleRepository;

    public SaleServiceImpl(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale makeSale(Sale sale) {
        return saleRepository.save(sale);
    }
}

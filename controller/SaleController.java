package controller;

import model.Sale;
import services.SaleService;

import java.util.List;

public class SaleController {

    private final SaleService saleService;
    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    public Sale makeSale(Sale sale){
        return this.saleService.makeSale(sale);
    }

    public List<Sale> getAll(){
        return this.saleService.getAll();
    }
}

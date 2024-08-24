package controller;

import model.Sale;
import services.SaleService;

public class SaleController {

    private final SaleService saleService;
    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    public Sale makeSale(Sale sale){
        return this.saleService.makeSale(sale);
    }

}

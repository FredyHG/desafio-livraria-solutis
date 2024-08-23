package factory;

import model.Electronic;
import model.Printed;

import java.util.List;

public class BookFactory {
    public static Electronic createElectronic(String title,
                                              Double price,
                                              String publisher,
                                              List<String> author,
                                              Integer size) {
        return new Electronic(title, price, publisher, author, size);
    }

    public static Printed createPrinted(String title,
                                        Double price,
                                        String publisher,
                                        List<String> author,
                                        Float freight,
                                        Integer stock) {
        return new Printed(title, price, publisher, author, freight, stock);
    }
}

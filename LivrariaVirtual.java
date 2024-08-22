
import controller.BookController;
import factory.BookFactory;
import repository.BookRepositoryImpl;
import services.BookServiceImpl;


public class LivrariaVirtual {

    public static void main(String[] args) {

    }

    public static void panel() {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        BookServiceImpl bookServiceImpl = new BookServiceImpl(bookRepository);
        BookController bookController = new BookController(bookServiceImpl);

        //Implementar painel
        //chamar os metodos de controller

        BookFactory.createElectronic(null, null, null, null, null); //example factory
    }
}

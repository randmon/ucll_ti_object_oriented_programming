import utils.Euro;

public class Book extends Product {

    protected Book(String title, Euro price, double stock) {
        super(title, price, stock);
    }

    protected Book(String title, Euro price) {
        super(title, price);
    }
}

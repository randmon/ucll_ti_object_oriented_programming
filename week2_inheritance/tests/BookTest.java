import org.junit.Test;
import utils.Euro;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void test_increaseStock_addsToStock() {
        Book b = new Book("B", new Euro(10), 10);
        b.restock(5);
        assertEquals(15, b.getStock(), 0.001);
        b.restock(5);
        assertEquals(20, b.getStock(), 0.001);
    }

    @Test
    public void test_decreaseStock_removesFromStock() {
        Book b = new Book("B", new Euro(10), 10);
        b.sell();
        assertEquals(9, b.getStock(), 0.001);
        b.sell();
        assertEquals(8, b.getStock(), 0.001);
    }

    @Test (expected = IllegalStateException.class)
    public void test_sell_whenStockIsZero_throwsException() {
        Book b = new Book("B", new Euro(10), 0);
        b.sell();
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_restock_whenAmountIsNegative_throwsException() {
        Book b = new Book("B", new Euro(10), 0);
        b.restock(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_negativeStock_throwsException() {
        new Book("B", new Euro(10), -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_negativePrice_throwsException() {
        new Book("B", new Euro(-10), 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void test_nullTitle_throwsException() {
        new Book(null, new Euro(10), 0);
    }
}
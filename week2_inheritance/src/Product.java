import utils.Euro;

public abstract class Product {
    private final String title;
    private final Euro price;
    private double stock;

    protected Product(String title, Euro price, double stock) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (price.isNegative()) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }

    protected Product(String title, Euro price) {
        this(title, price, 0);
    }

    public String getTitle() {
        return title;
    }

    public Euro getPrice() {
        return price;
    }

    public double getStock() {
        return stock;
    }

    private void setStock(double stock) {
        this.stock = stock;
    }

    public void sell() {
        if (stock < 1) throw new IllegalStateException("Out of stock");
        setStock(stock - 1);
        System.out.println(title + " sold, there are " + stock + " left");
    }

    public void restock(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount must be positive");
        setStock(stock + amount);
        System.out.println(amount + " " + title + " added, there are " + stock + " in stock");
    }
}

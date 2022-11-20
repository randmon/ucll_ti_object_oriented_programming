import utils.Euro;

import java.time.LocalDate;

public class Newspaper extends Product {
    private final LocalDate weekOfPublication;

    protected Newspaper(String title, Euro price, double stock, LocalDate weekOfPublication) {
        super(title, price, stock);
        this.weekOfPublication = weekOfPublication;
    }

    protected Newspaper(String title, Euro price, LocalDate weekOfPublication) {
        super(title, price);
        this.weekOfPublication = weekOfPublication;
    }

    public LocalDate getWeekOfPublication() {
        return weekOfPublication;
    }
}

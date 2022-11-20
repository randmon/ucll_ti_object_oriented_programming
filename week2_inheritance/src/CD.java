import utils.Euro;

public class CD extends Product {
    private final String artist;
    private final int year;

    protected CD(String title, Euro price, double stock, String artist, int year) {
        super(title, price, stock);
        this.artist = artist;
        this.year = year;
    }

    protected CD(String title, Euro price, String artist, int year) {
        super(title, price);
        this.artist = artist;
        this.year = year;
    }
}

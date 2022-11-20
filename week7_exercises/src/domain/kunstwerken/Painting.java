package domain.kunstwerken;

import domain.interfaces.Sellable;
import domain.utils.DomainException;
import utils.Euro;

public class Painting extends Artwork implements Sellable {
    private final double height, length;
    private Euro value;
    private boolean sold;

    public Painting(String artist, String title, double height, double length, Euro value) {
        super(artist, title);
        if (height <= 0) throw new DomainException("Height must be positive!");
        this.height = height;
        if (length <= 0) throw new DomainException("Length must be positive!");
        this.length = length;
        setValue(value);
        setCanBorrow();
    }

    private void setCanBorrow() {
        this.canBorrow = (height <= 150 || length <= 150) && !sold;
    }

    @Override
    public boolean isSold() {
        return sold;
    }

    @Override
    public void sell() throws DomainException {
        if (sold) throw new DomainException("Painting is already sold!");
        sold = true;
        canBorrow = false;
    }

    public Euro getValue() {
        return value;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public void setValue(Euro value) throws DomainException{
        if (value == null || !value.isPositive()) throw new DomainException("Value must be positive!");
        this.value = value;
    }

    @Override
    public Euro getPrice() {
        return value.multiply(1.10);
    }

    @Override
    public String toString() {
        return """
            Painting
                    Artist: %s
                    Title: %s
                    Dimensions: %s x %s
                    Sold: %s - Price: %s
            """.formatted(getArtist(), getTitle(), height, length, sold ? "Yes" : "No", getPrice());
    }
}

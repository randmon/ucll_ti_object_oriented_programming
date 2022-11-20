package domain.gifts;

import domain.interfaces.HasMinimumAge;
import utils.Euro;

public class Toy extends Gift implements HasMinimumAge {
    private final String name, manufacturer;
    private final int minimumAge;

    public Toy(String name, String manufacturer, Euro price, int minimumAge) {
        super(price);
        checkNotNull(name);
        this.name = name;
        checkNotNull(manufacturer);
        this.manufacturer = manufacturer;
        if (minimumAge < 0) throw new IllegalArgumentException();
        this.minimumAge = minimumAge;
    }

    public Toy(String name, String manufacturer, Euro prijs) {
        this(name, manufacturer, prijs,0 );
    }

    @Override
    public int getMinimumAge() {
        return minimumAge;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        String result = "Toy: " + name +
                "\n\t\tManufacturer: " + manufacturer;
        if (minimumAge != 0) result += "\n\t\tMinimum age: " + minimumAge;
        result += "\n\t\t" + getPrice() + "\n";
        return result;
    }
}

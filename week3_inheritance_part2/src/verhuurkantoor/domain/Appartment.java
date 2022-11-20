package verhuurkantoor.domain;

import utils.Euro;

public class Appartment extends Residency {
    private final int rooms;

    public Appartment(int floor, int number, Euro pricePerM2, double area, int rooms) {
        super(floor, number, pricePerM2, area);
        if (rooms < 1) throw new IllegalArgumentException("There must be at least 1 room");
        this.rooms = rooms;
    }

    @Override
    protected void setPrice() {
        price = new Euro(pricePerM2.getTotalCents() * area / 100);
        for (int i = 3; i < rooms; ++i) {
            price.add(new Euro(100));
        }
    }

    @Override
    public String toString() {
        return "Appartement" + getInfo(this);
    }
}

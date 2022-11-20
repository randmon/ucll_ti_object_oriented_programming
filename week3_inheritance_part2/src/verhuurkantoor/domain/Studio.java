package verhuurkantoor.domain;

import utils.Euro;

public class Studio extends StudentResidency {
    private final double areaBathroom;

    public Studio(int floor, int number, Euro pricePerM2, double area, double areaBathroom) {
        super(floor, number, pricePerM2, area);
        if (areaBathroom < 1) throw new IllegalArgumentException("Area of bathroom must be at least 1 m2");
        this.areaBathroom = areaBathroom;
    }

    @Override
    protected void setPrice() {
        price = new Euro(pricePerM2.getTotalCents() * area / 100).add(
                new Euro(pricePerM2.getTotalCents() * 2 * areaBathroom)
        );
    }
}

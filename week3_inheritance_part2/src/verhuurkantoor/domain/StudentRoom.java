package verhuurkantoor.domain;

import utils.Euro;

public class StudentRoom extends StudentResidency {
    public StudentRoom(int floor, int number, Euro pricePerM2, double area) {
        super(floor, number, pricePerM2, area);
    }

    @Override
    public void setPrice() {
        price = new Euro(pricePerM2.getTotalCents() * area / 100);
    }

    @Override
    public String toString() {
        return "Studentenkamer" + getInfo(this);
    }
}

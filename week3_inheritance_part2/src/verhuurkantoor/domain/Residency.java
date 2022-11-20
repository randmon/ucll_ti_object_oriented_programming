package verhuurkantoor.domain;

import utils.Euro;

public abstract class Residency {
    protected int floor, number;
    protected Euro pricePerM2, price;
    protected double area;
    protected boolean isRented;

    //Constructor
    public Residency(int floor, int number, Euro pricePerM2, double area) {
        setFloor(floor);
        setNumber(number);
        setPricePerM2(pricePerM2);
        setArea(area);
        isRented = false;
        setPrice();
    }

    private void setFloor(int floor) {
        if (floor < 0) throw new IllegalArgumentException("Floor numbers must be positive");
        this.floor = floor;
    }

    private void setNumber(int number) {
        if (number < 1) throw new IllegalArgumentException("Numbers must be positive");
        this.number = number;
    }

    private void setArea(double area) {
        if(area < 12) throw new IllegalArgumentException("Area must be at least 12 m²");
        this.area = area;
    }

    //Effectieve prijs is vershchillend voor elke type verblijf
    protected void setPrice() {
        // Default is prijs per m² * area
        price = new Euro(pricePerM2.getTotalCents() * area / 100);
    }

    public void setRented(boolean isRented) {
        if (this.isRented && isRented) throw new IllegalArgumentException("Residence is already rented!");
        else if (!this.isRented && !isRented) throw new IllegalArgumentException("Residence is already not rented!");
        this.isRented = isRented;
    }

    public void setPricePerM2(Euro pricePerM2) {
        if (pricePerM2.isNegative()) throw new IllegalArgumentException("Price per m² must be positive");
        this.pricePerM2 = pricePerM2;
    }

    public int getFloor() {
        return floor;
    }

    public int getNumber() {
        return number;
    }

    public double getArea() {
        return area;
    }

    public Euro getPricePerM2() {
        return pricePerM2;
    }

    public boolean isRented() {
        return isRented;
    }

    public Euro getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getInfo(this);
    }

    protected static String getInfo(Residency v) {
        String result = "\nBus " + v.floor + "." + v.number +
                "\nPrijs: " + v.price +
                "\nGrootte: " + v.area + " m²\n";
        if (!v.isRented) result += "niet ";
        result += "verhuurd";
        return result;
    }
}

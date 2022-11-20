package verhuurkantoor.domain;

import utils.Euro;

import java.util.ArrayList;

public class Building {
    private final String name, street, city;
    private final int number, zipcode, floors;
    private final ArrayList<Residency> residencies;

    public Building(String name, String street, int number, int zipcode, String city, int floors) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or empty!");
        this.name = name;
        if (street == null || street.isBlank()) throw new IllegalArgumentException("Street cannot be null or empty!");
        this.street = street;
        if (city == null || city.isBlank()) throw new IllegalArgumentException("City cannot be null or empty!");
        this.city = city;
        if (number < 1) throw new IllegalArgumentException("Invalid number!");
        this.number = number;
        if (zipcode < 0) throw new IllegalArgumentException("Invalid zipcode!");
        this.zipcode = zipcode;
        if (floors < 1) throw new IllegalArgumentException("Invalid number of floors!");
        this.floors = floors;
        residencies = new ArrayList<>();
    }

    public void addResidency(Residency r) {
        if (r == null) throw new IllegalArgumentException("Residence cannot be null!");
        if (residencies.contains(r)) throw new IllegalArgumentException("This residence is already in the list!");
        //Check if verdieping-verblijfnummer combination is already in use
        for (Residency residency : residencies) {
            if (r.floor == residency.floor && r.number == residency.number) {
                throw new IllegalArgumentException("This floor and number combination is already in use!");
            }
        }
        if (r.floor > floors) throw new IllegalArgumentException(
                "This floor is not in the building, there are only " + floors + " floors!");
        residencies.add(r);
    }

    public int getAmountFree() {
        return (int) residencies.stream().filter(r -> !r.isRented()).count();
    }

    public ArrayList<StudentResidency> getResidenciesTaxNotPaid() {
        return residencies.stream().filter(r -> r instanceof StudentResidency)
                .map(r -> (StudentResidency) r)
                .filter(r -> !r.isTaxPaid())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public Euro getTotalPrice() {
        return residencies.stream().map(r -> r.price).reduce(new Euro(0), Euro::add);
    }

    @Override
    public String toString() {
        return """
                Building: %s %d, %d %s
                Floors: %d
                Residencies: %d
                Free residencies: %d
                Total price: %s
                """.formatted(street, number, zipcode, city, floors, residencies.size(), getAmountFree(), getTotalPrice());
    }
}

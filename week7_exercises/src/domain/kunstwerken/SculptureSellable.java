package domain.kunstwerken;

import domain.interfaces.Sellable;
import domain.utils.DomainException;
import utils.Euro;

public class SculptureSellable extends Sculpture implements Sellable {
    private Euro value;
    private boolean sold;


    public SculptureSellable(String artist, String title, int weight, String material, Euro value) {
        super(artist, title, weight, material);
        this.value = value;
        this.sold = false;
    }

    @Override
    public boolean isSold() {
        return sold;
    }

    @Override
    public void sell() throws DomainException {
        if (sold) throw new DomainException("Schilderij is al verkocht!");
        sold = true;
        canBorrow = false;
    }

    public void setValue(Euro value) throws DomainException{
        if (value == null || value.isNegative()) throw new DomainException("Waarde moet positief zijn!");
        this.value = value;
    }

    @Override
    public Euro getPrice() {
        return value.multiply(1.15);
    }

    @Override
    public String toString() {
//        String result = "BeeldhouwwerkVerkoopbaar uitvoerder= " + getArtist()
//                +", titel= " + getTitle() + ", ";
//        if (!sold) result += "NIET ";
//        return result + "VERKOCHT, materiaal " + getMaterial() + ", gewicht = " + getWeight()
//                + " gram, waarde = " + value;

        return """
            Sculpture (Sellable)
                    Artist: %s
                    Title: %s
                    Material: %s
                    Weight: %d
                    Sold: %s - Price: %s
            """.formatted(getArtist(), getTitle(), getMaterial(), getWeight(),
            sold ? "Yes" : "No", getPrice());
    }
}

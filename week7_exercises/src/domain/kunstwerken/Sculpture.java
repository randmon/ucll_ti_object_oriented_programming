package domain.kunstwerken;

import domain.utils.DomainException;

public class Sculpture extends Artwork {
    private final int weight;
    private final String material;

    public Sculpture(String artist, String title, int weight, String material) throws DomainException {
        super(artist, title);

        if (weight < 1) throw new DomainException("Weight must be positive!");
        this.weight = weight;

        if (checkEmpty(material)) throw new DomainException("Material must not be empty!");
        this.material = material;

        setUitleenbaar();
    }

    private void setUitleenbaar() {
        canBorrow = weight < 15000;
    }

    public int getWeight() {
        return weight;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return """
            Sculpture
                    Artist: %s
                    Title: %s
                    Material: %s
                    Weight: %d
                    Lendable: %s
            """.formatted(getArtist(), getTitle(), getMaterial(), getWeight(), canBorrow());
    }
}

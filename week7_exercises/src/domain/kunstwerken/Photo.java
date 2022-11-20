package domain.kunstwerken;

import domain.interfaces.Sellable;
import domain.utils.DomainException;
import utils.Euro;

public class Photo extends Artwork implements Sellable {
    private final boolean blackAndWhite;
    private boolean sold;

    public Photo(String artist, String title, boolean blackAndWhite) {
        super(artist, title);
        this.blackAndWhite = blackAndWhite;
        sold = false;
    }

    @Override
    public boolean isSold() {
        return sold;
    }

    @Override
    public void sell() throws DomainException {
        if (sold) throw new DomainException("Schilderij is al verkocht!");
        sold = true;
    }

    @Override
    public Euro getPrice() {
        return new Euro(blackAndWhite ? 100 : 200);
    }

    @Override
    public String
    toString() {
        return """
            Photo
                    Artist: %s
                    Title: %s
                    Color: %s
                    Sold: %s - Price: %s
            """.formatted(getArtist(), getTitle(), blackAndWhite ? "Black and White" : "Color",
            sold ? "Yes" : "No", getPrice());
    }
}

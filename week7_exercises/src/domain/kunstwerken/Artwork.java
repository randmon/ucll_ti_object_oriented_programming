package domain.kunstwerken;

import domain.utils.DomainException;

public abstract class Artwork {
    private final String artist, title;
    protected boolean canBorrow;

    public Artwork(String artist, String title) throws DomainException {
        if (checkEmpty(artist)) throw new DomainException("Artist must not be empty!");
        this.artist = artist;

        if (checkEmpty(title)) throw new DomainException("Title must not be empty!");
        this.title = title;

        canBorrow = false; // default
    }

    protected boolean checkEmpty(String s) {
        return s == null || s.isBlank();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artwork artwork)) return false;

        return title.equals(artwork.title) && artist.equals(artwork.artist);
    }

    public boolean canBorrow() {
        return canBorrow;
    }

    @Override
    public abstract String toString();
}

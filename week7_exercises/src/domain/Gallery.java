package domain;

import domain.interfaces.Sellable;
import domain.kunstwerken.Artwork;
import domain.utils.DomainException;
import utils.Euro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gallery {
    private final String name;
    private final ArrayList<Artwork> collection;


    public Gallery(String name) {
        if (name == null || name.isBlank()) throw new DomainException("Name must not be empty!");
        this.name = name;
        collection = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Artwork> getCollection() {
        return collection;
    }

    public void addToCollection(Artwork artwork) throws DomainException {
        for (Artwork a : collection) {
            if (a.equals(artwork))
                throw new DomainException(String.format("Artwork %s by %s is already in the collection!",
                        artwork.getTitle(), artwork.getArtist()));
        }
        collection.add(artwork);
    }

    public List<Artwork> getBorrowable() {
        return collection.stream().filter(Artwork::canBorrow).toList();
    }

    public List<Artwork> getSellable() {
        return collection.stream().filter(a -> a instanceof Sellable).toList();
    }

    public List<Artwork> getForSaleMaxPrice(Euro maxPrice) {
        return collection.stream().filter(a -> a instanceof Sellable)
                .filter(a -> ((Sellable) a).getPrice().lessOrEqual(maxPrice)).toList();
    }

    public List<Artwork> removeByArtist(String artist) {
        List<Artwork> removed = new ArrayList<>();
        Iterator<Artwork> it = collection.iterator();
        while (it.hasNext()) {
            Artwork a = it.next();
            if (a.getArtist().equals(artist)) {
                removed.add(a);
                it.remove();
            }
        }
        return removed;

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Gallery: " + name);
        for (int i = 0; i < collection.size(); ++i) {
            result.append("\n").append(i + 1).append(" - ").append(collection.get(i));
        }
        return result.toString();
    }
}

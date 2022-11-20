package domain;

import domain.gifts.Gift;
import domain.interfaces.HasNotNullParameters;
import domain.interfaces.Perishable;
import domain.interfaces.HasMinimumAge;
import utils.Euro;
import java.util.ArrayList;
import java.util.List;

public class GiftBox implements HasNotNullParameters {
    private final List<Gift> giftList;
    private final Person gifter, receiver;


    public GiftBox(Person gifter, Person receiver, Gift gift) {
        checkNotNull(gifter);
        this.gifter = gifter;
        checkNotNull(receiver);
        if (receiver.equals(gifter)) throw new IllegalArgumentException("gifter and receiver cannot be the same person");
        this.receiver = receiver;
        checkNotNull(gift);
        giftList = new ArrayList<>();
        addGift(gift);
    }

    public void addGift(Gift g) {
        checkNotExpired(g);
        checkMinAge(g);
        giftList.add(g);
    }

    private void checkNotExpired(Gift g) {
        if (g instanceof Perishable p) {
            if (p.isExpired()) throw new IllegalArgumentException("This " + g.getClass().getSimpleName() + " is expired");
        }
    }

    private void checkMinAge(Gift g) {
        if (g instanceof HasMinimumAge h) {
            if (h.getMinimumAge() > receiver.getAge())
                throw new IllegalArgumentException("This " + g.getClass().getSimpleName() + " is not suitable for this person " +
                        "(must be at least " + h.getMinimumAge() + " years old)");
        }
    }

    public Euro totalePrijs() {
        return giftList.stream().map(Gift::getPrice).reduce(new Euro(0), Euro::add);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n--------------\n");
        result.append("Giftbox from ").append(gifter).append(" to ").append(receiver).append("\n");
        for (Gift g : giftList) {
            result.append("\n - ").append(g);
        }
        result.append("\n\nTotal price: ").append(totalePrijs());
        result.append("\n--------------\n");

        return result.toString();
    }
}

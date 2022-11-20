package domain.interfaces;

import domain.utils.DomainException;
import utils.Euro;

public interface Sellable {
    boolean isSold();
    void sell() throws DomainException;
    Euro getPrice();
}

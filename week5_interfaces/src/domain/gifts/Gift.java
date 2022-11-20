package domain.gifts;

import domain.interfaces.HasNotNullParameters;
import utils.Euro;

public abstract class Gift implements HasNotNullParameters {
    private final Euro price;

    public Gift(Euro price) {
        this.price = price;
    }

    public Euro getPrice() {
        return price;
    }

    @Override
    public abstract String toString();
}

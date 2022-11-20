package domain.gifts;

import java.time.LocalDate;

import domain.interfaces.Perishable;
import utils.Euro;

public class Candy extends Gift implements Perishable {
    private final String name;
    private final LocalDate expirationDate;

    public Candy(String name, LocalDate expirationDate, Euro price) {
        super(price);
        checkNotNull(name);
        this.name = name;
        checkNotNull(expirationDate);
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

    @Override
    public String toString() {
        return """
                Candy: %s
                        Expiration date: %s (expired: %s)
                        %s
                """.formatted(name, expirationDate, isExpired(), getPrice());
    }

    public String getName() {
        return name;
    }
}

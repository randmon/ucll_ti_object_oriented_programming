package domain.interfaces;

import java.time.LocalDate;

public interface Perishable {
    LocalDate getExpirationDate();
    default boolean isExpired() {
        return getExpirationDate().isBefore(LocalDate.now());
    }
}

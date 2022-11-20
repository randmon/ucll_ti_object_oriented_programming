package verhuurkantoor.domain;

public interface PaysMunicipalTax {
    boolean isTaxPaid();
    void setTaxPaid(boolean paid);

    default void checkPaid(boolean paid) {
        if (isTaxPaid() && paid) throw new IllegalArgumentException("Tax is already paid!");
        else if (!isTaxPaid() && !paid) throw new IllegalArgumentException("Tax is already not paid!");
    }
}

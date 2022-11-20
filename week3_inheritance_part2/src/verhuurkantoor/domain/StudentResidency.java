package verhuurkantoor.domain;

import utils.Euro;

public abstract class StudentResidency extends Residency implements PaysMunicipalTax {
    private boolean municipalTaxPaid;

    public StudentResidency(int floor, int number, Euro pricePerM2, double area) {
        super(floor, number, pricePerM2, area);
        municipalTaxPaid = false;
        setPrice();
    }

    @Override
    public void setTaxPaid(boolean paid) {
        checkPaid(paid);
        this.municipalTaxPaid = paid;
    }

    @Override
    public boolean isTaxPaid() {
        return municipalTaxPaid;
    }
}

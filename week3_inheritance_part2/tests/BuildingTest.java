import utils.Euro;
import org.junit.Before;
import org.junit.Test;
import verhuurkantoor.domain.Residency;
import verhuurkantoor.domain.Building;
import verhuurkantoor.domain.StudentRoom;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildingTest {
    private Building r1, r2;
    private StudentRoom sk1;
    private Euro euro10;

    @Before
    public void setUp() {
        r2= new Building("Pegasus", "Maanstrat", 12, 3001, "Heverlee", 2);
        sk1 = new StudentRoom(1, 1, new Euro(10), 15);
        euro10 = new Euro(10,0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_nullNaam_gooitException() {
        r1 = new Building(null, "Maanstrat", 12, 3001, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_legeNaam_gooitException() {
        r1 = new Building(" ", "Maanstrat", 12, 3001, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_nullStraat_gooitException() {
        r1 = new Building("Pegasus", null, 12, 3001, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_legeStraat_gooitException() {
        r1 = new Building("Pegasus", " ", 12, 3001, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_nummerNul_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", 0, 3001, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_nummerNegatief_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", -10, 3001, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_postcodeNegatief_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", 10, -2000, "Heverlee", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_legeGemeente_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", 10, 3001, " ", 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_nullGemeente_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", 10, 3001, null, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_aantalVerdiepingenNul_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", 10, 3001, "Heverlee", 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void residentie_aantalVerdiepingenNegatief_gooitException() {
        r1 = new Building("Pegasus", "Maanstraat", 10, 3001, "Heverlee", -10);
    }

    @Test
    public void residentie_correcteParameters() {
        r1 = new Building("Pegasus", "Maanstraat", 785, 3001, "Heverlee", 20);
    }

    @Test
    public void getAantalVrij_zonderVerblijven_aantalVrij_Nul() {
        r1 = new Building("Pegasus", "Maanstraat", 785, 3001, "Heverlee", 20);
        assertEquals(r1.getAmountFree(), 0);
        assertEquals(r2.getAmountFree(), 0);
    }

    @Test
    public void getAantalVrij_addEenVerblijf() {
        r2.addResidency(sk1);
        assertEquals(r2.getAmountFree(), 1);
        sk1.setRented(true);
        assertEquals(r2.getAmountFree(), 0);
    }

    @Test
    public void getAantalVrij_addMeerdereVerblijven() {
        r2.addResidency(sk1);
        assertEquals(r2.getAmountFree(), 1);
        sk1.setRented(true);
        assertEquals(r2.getAmountFree(), 0);

        r2.addResidency(new StudentRoom(1, 2, euro10, 23));
        r2.addResidency(new StudentRoom(1, 3, euro10, 23));

        assertEquals(r2.getAmountFree(), 2);

        sk1.setRented(false);
        assertEquals(r2.getAmountFree(), 3);
    }

    @Test
    public void getGbelastingNietBetaald_zonderVerblijven_legeLijst() {
        assertEquals(r2.getResidenciesTaxNotPaid().size(), 0);
    }

    @Test
    public void getGbelastingNietBetaald_eenVerblijfNietBetaald_lijstMetDatVerblijf() {
        r2.addResidency(sk1);
        assertEquals(r2.getResidenciesTaxNotPaid().size(), 1);
        ArrayList<Residency> test = new ArrayList<>();
        test.add(sk1);
        assertEquals(r2.getResidenciesTaxNotPaid(), test);
    }

    @Test
    public void getGbelastingNietBetaald_eenVerblijfAlBetaald_legeLijst() {
        r2.addResidency(sk1);
        sk1.setTaxPaid(true);
        assertEquals(r2.getResidenciesTaxNotPaid().size(), 0);
    }

    @Test
    public void getGbelastingNietBetaald_tweeKeerOproepen() {
        r2.addResidency(sk1);
        assertEquals(r2.getResidenciesTaxNotPaid().size(), 1);
        ArrayList<Residency> test = new ArrayList<>();
        test.add(sk1);
        assertEquals(r2.getResidenciesTaxNotPaid(), test);

        sk1.setTaxPaid(true);
        assertEquals(r2.getResidenciesTaxNotPaid().size(), 0);
    }

    @Test
    public void getTotalePrijs_zonderVerblijven_nul() {
        assertTrue(r2.getTotalPrice().equals(new Euro(0)));
    }

    @Test
    public void getTotalePrjis_correct() {
        r2.addResidency(new StudentRoom(1, 2, euro10, 100));
        assertTrue(r2.getTotalPrice().equals(new Euro(1000)));

        r2.addResidency(new StudentRoom(1, 3, euro10, 100));
        assertTrue(r2.getTotalPrice().equals(new Euro(2000)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addVerblijf_nullVerblijf_gooitException() {
        r2.addResidency(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addVerblijf_teHoogVerdieping_gooitException() {
        r2.addResidency(new StudentRoom(3, 1, euro10, 12));
    }

    @Test
    public void addVerblijf_laatsteVerdieping() {
        r2.addResidency(new StudentRoom(1, 1, euro10, 12));
    }

    @Test
    public void addVerblijf_gelijkVloer() {
        r2.addResidency(new StudentRoom(0, 1, euro10, 12));
    }

    @Test (expected = IllegalArgumentException.class)
    public void addVerblijf_alBestaandeVerblijf_gooitException() {
        r2.addResidency(new StudentRoom(0, 1, euro10, 12));
        r2.addResidency(new StudentRoom(0, 1, euro10, 12));
    }
}
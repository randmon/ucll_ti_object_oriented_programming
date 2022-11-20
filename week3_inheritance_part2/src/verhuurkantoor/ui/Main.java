package verhuurkantoor.ui;

import utils.Euro;
import verhuurkantoor.domain.Appartment;
import verhuurkantoor.domain.Building;
import verhuurkantoor.domain.StudentRoom;
import verhuurkantoor.domain.Studio;

public class Main {
    public static void main(String[] args) {
        StudentRoom sr = new StudentRoom(2, 15, new Euro(10,0), 12);
        System.out.println(sr + "\n");

        Appartment a = new Appartment(2, 2, new Euro(30), 150, 4);
        System.out.println(a + "\n");

        Building b = new Building("Pegasus", "Maanstraat", 785, 3001, "Heverlee", 12);
        Studio s = new Studio(2, 1, new Euro(30), 150, 4);
        b.addResidency(s);
        b.addResidency(sr);
        b.addResidency(a);
        System.out.println(b);
    }
}

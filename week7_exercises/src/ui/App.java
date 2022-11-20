package ui;

import domain.Gallery;
import domain.kunstwerken.SculptureSellable;
import domain.kunstwerken.Photo;
import domain.kunstwerken.Painting;
import domain.utils.DomainException;
import utils.Euro;

public class App {
    public static void main(String[] args) {
        try {
            Painting s = new Painting("Cristina", "Purple Sunset", 120, 120, new Euro(5.1));
            Photo f = new Photo("Cristina", "Pizza box", true);
            SculptureSellable bv= new SculptureSellable(
                    "Astrid", "Crazy Frog", 550,"iron", new Euro(350));
            Gallery gallery = new Gallery("Good Art");

            gallery.addToCollection(s);
            print(gallery);
            hr();

            s.sell();
            gallery.addToCollection(f);
            gallery.addToCollection(bv);
            print("\n" + gallery);
            hr();

            print("\nUitleenbaar : ");
            gallery.getBorrowable().forEach(System.out::println);
            hr();

            print("\nVerkoopbaar : ");
            gallery.getSellable().forEach(System.out::println);
            hr();

            print("\nVerkoopbaar Niet Verkocht Max Prijs 500€:");
            gallery.getForSaleMaxPrice(new Euro(500)).forEach(System.out::println);
            hr();

            //verwijderen van uitvoerder geeft lijst terug
            print("\nVerwijderd van \"Cristina\"");
            gallery.removeByArtist("Cristina").forEach(System.out::println);
            hr();

            //kunstwerken zijn efectief weg
            System.out.println("\n"+gallery);


        } catch (DomainException e) {
            e.printStackTrace();
        }

    }

    public static void print(Object o) {
        System.out.println(o);
    }
    public static void hr() {
        print("------------------------");
    }
}

package ui;

import domain.GiftBox;
import domain.Person;
import domain.gifts.*;
import utils.Euro;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Book harrypotter = new Book("Harry Potter 1", "J. K. Rowling", 300, new Euro(12));
        Book sqlBook = new Book("SQL leerboek", "John Doe", 700, new Euro(66,66));
        Candy candy1 = new Candy("sour candy", LocalDate.of(LocalDate.now().getYear() + 1, 3, 12), new Euro(0,5));
        Toy pop = new Toy("Barbie", "BBco", new Euro(8), 5);
        Toy chewtoy = new Toy("Chewing toy", "Preciozi", new Euro(13, 12));

        Person kris = new Person("Kris", "Keersmaekers", LocalDate.of(1998, 4,8));
        Person cristina = new Person("Cristina", "Marques", LocalDate.of(1998,9, 10));

        GiftBox box1 = new GiftBox(kris, cristina, sqlBook);
        box1.addGift(harrypotter);

        GiftBox doos2 = new GiftBox(cristina, kris, candy1);
        for (int i = 0; i < 7; i++) doos2.addGift(candy1);
        doos2.addGift(pop);
        doos2.addGift(chewtoy);

        System.out.println(box1);
        System.out.println(doos2);
    }
}

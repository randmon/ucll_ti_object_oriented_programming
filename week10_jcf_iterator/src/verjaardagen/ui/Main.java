package verjaardagen.ui;

import verjaardagen.domain.Person;
import verjaardagen.domain.BirthdayCalendar;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		BirthdayCalendar kalender = new BirthdayCalendar();
		Person tim = new Person("Frederiks","Tim",LocalDate.of(2011,12,1));
		Person tom = new Person("Adams","Tom",LocalDate.of(1999,12,12));
		Person ann = new Person("Alders","Ann",LocalDate.of(2014,4,1));
		Person jef = new Person("Jackers","Jef",LocalDate.of(2012,12,1));
		Person anne = new Person("Van anders","Anne",LocalDate.of(1987,11,1));
		Person cristina = new Person("Marques","Cristina",LocalDate.of(1998,9,10));
		Person rita = new Person("Perez","Rita",LocalDate.of(1998,9,10));

		kalender.addBirthday(ann);
		kalender.addBirthday(jef);
		kalender.addBirthday(tom);
		kalender.addBirthday(tim);
		kalender.addBirthday(anne);
		kalender.addBirthday(cristina);
		kalender.addBirthday(rita);

		System.out.println(kalender);
		System.out.println("________________________________");

		kalender.removePerson(jef);
		System.out.println("Jef uit kalender");
		System.out.println(kalender);
		System.out.println("________________________________");

		System.out.println("Tim uit kalender");
		kalender.removePerson(tim);
		System.out.println(kalender);
	}
}

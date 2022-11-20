package family_app.ui;

import family_app.domain.DomainException;
import family_app.domain.Family;
import family_app.domain.Person;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person anne = new Person("Anne", 10);
		Person bert = new Person("Bert", 12);
		Person chris = new Person("Chris", 13);

		Family family = new Family("Rodenburg");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name and age of family member");

		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Age: ");
		String age = scanner.nextLine();

		try {
			family.addMember(name, age);
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}

		try {
			family.addMember(anne);
			family.addMember(bert);
			family.addMember(chris);
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}

		try {
			family.addMember(anne);
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(family);
	}
}

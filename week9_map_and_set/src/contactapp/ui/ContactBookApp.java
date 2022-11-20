package contactapp.ui;

import contactapp.domain.ContactBook;
import contactapp.domain.Contact;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class ContactBookApp {
	public static void main(String[] args) {
		Contact[] contactList1 = {
				new Contact ("Depeel","Andi","016111111"),
				new Contact ("Depeel","Els","016111111"),
				new Contact ("Dox","Jo","016222211"),
				new Contact ("Adons","Andi","016111333"),
				new Contact ("Adons","Dirk","016111333"),
				new Contact ("Vranken","Rita","011999999"),
				new Contact ("Vangeel","Anja","011111112")
		};
		Contact [] contactList2 = {
				new Contact ("Depeel","Els","016111111"),
				new Contact ("Degrijse","Jan","011224511"),
				new Contact ("Adons","Andi","016111333"),
				new Contact ("Depeel","Andi","016111111"),
				new Contact ("Adons","Robrecht","016111333"),
				new Contact ("Vranken","Rita","011999999"),
				new Contact ("Vanlo","Kris","016190111"),
				new Contact ("Dero","Eno","011111112")
		};
		ContactBook contactBook1 = new ContactBook(new LinkedHashSet<>(Arrays.asList(contactList1)));
		ContactBook contactBook2 = new ContactBook(new LinkedHashSet<>(Arrays.asList(contactList2)));

		print("Alle contacten uit adresboek 1 in volgorde van toevoeging");
		print(contactBook1);
		print("Alle contacten uit adresboek 2 in volgorde van toevoeging");
		print(contactBook2);
		print("Alle gemeenschappelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam");
		print(contactBook1.contactsInCommon(contactBook2));
		print("Alle gezamelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam");
		print(contactBook1.contactsJoint(contactBook2));
		print("Alle contacten uit adresboek 1 die niet voorkomen in adresboek 2 in alfabetische volgorde achternaam/voornaam");
		print(contactBook1.differentContacts(contactBook2));
		Contact nieuwContact = new Contact ("Dox","Jo","016222211");
		print("Dox Jo"+ (contactBook1.addContact(nieuwContact)?" toegevoegd ":" niet toegevoegd ")+"aan adresboek 1");
		nieuwContact = new Contact ("Rummens","Rani","013288338");
		print("Rummens Rani"+ (contactBook1.addContact(nieuwContact)?" toegevoegd ":" niet toegevoegd ")+"aan adresboek 1");
		print ("Aantal verwijderde contacten met achtternaam Adons uit adresboek 1: " + contactBook1.removeByLastName("Adons"));
		print("Alle contacten uit adresboek 1 in volgorde van toevoeging na aanpassingen");
		print(contactBook1);
	}

	private static void print(Object o) {
		System.out.println(o);
	}
}
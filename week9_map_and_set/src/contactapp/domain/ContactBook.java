package contactapp.domain;

import java.util.*;

public class ContactBook {
	private final Set<Contact> contacts;

	public ContactBook() {
		contacts = new LinkedHashSet<>();
	}

	public ContactBook(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	private Set<Contact> getContacts() {
		return contacts;
	}

	public ContactBook contactsInCommon(ContactBook c){
		if (c == null) throw new IllegalArgumentException("Cannot compare to null");
		Set<Contact> result = new LinkedHashSet<>(contacts);
		result.retainAll(c.contacts);
		return new ContactBook(result);
	}

	public ContactBook contactsJoint(ContactBook c) {
		if (c == null) throw new IllegalArgumentException("Cannot compare to null");
		Set<Contact> result = new TreeSet<>(contacts);
		result.addAll(c.contacts);
		return new ContactBook(result);
	}

	public ContactBook differentContacts(ContactBook c){
		if (c == null) throw new IllegalArgumentException("Cannot compare to null");
		Set<Contact> result = new TreeSet<>(contacts);
		result.removeAll(c.contacts);
		return new ContactBook(result);
	}

	public boolean addContact(Contact c) {
		if (c == null) throw new IllegalArgumentException("Cannot add null");
		return contacts.add(c);
	}

	public int removeByLastName(String lastName){
		if (lastName == null || lastName.isBlank()) {
			throw new IllegalArgumentException("Last name cannot be null or empty");
		}
		int counter = 0;
		Iterator<Contact> it = contacts.iterator();
		while (it.hasNext()){
			Contact c = it.next();
			if (c.getLastName().equals(lastName)) {
				it.remove();
				counter++;
			}
		}
		return counter;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Contacts: ").append(contacts.size()).append("\n");
		for (Contact contact : contacts) {
			result.append("\n\t\t").append(contact);
		}
		result.append("\n");
		return result.toString();
	}	
}


package contactapp.domain;

public class Contact implements Comparable<Contact> {
	private String name, lastName, phoneNumber;

	public Contact(String lastName, String name, String phoneNumber)  {
		setLastName(lastName);
		setName(name);
		setPhoneNumber(phoneNumber);
	}

	public String getLastName() {
		return lastName;
	}

	private void setLastName(String lastName) {
		if (lastName == null || lastName.isBlank())
			throw new IllegalArgumentException("Last name cannot be null or empty");
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	private void setName(String name)  {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Name cannot be null or empty");
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	private void setPhoneNumber(String phoneNumber)  {
		if (phoneNumber == null || phoneNumber.isBlank())
			throw new IllegalArgumentException("Phone number cannot be null or empty");
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o instanceof Contact c) {
			return c.getLastName().equals(lastName) && c.getName().equals(name) && c.getPhoneNumber().equals(phoneNumber);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = lastName.hashCode();
		result = 31 * result + name.hashCode();
		result = 31 * result + phoneNumber.hashCode();
		return result;
	}

	@Override
	public String toString(){
		return String.format("%-15s%-15s%10s", getLastName(), getName(), getPhoneNumber());
	}

	@Override
	public int compareTo(Contact o) {
		int result = lastName.compareTo(o.lastName);
		return result == 0 ? name.compareTo(o.name) : result;
	}
}

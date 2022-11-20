package verjaardagen.domain;

import java.time.LocalDate;
import java.time.Period;

public record Person(String lastName, String name, LocalDate birthday) {
	public Person {
		if (name == null || name.isBlank() ||
				lastName == null || lastName.isBlank() ||
				birthday == null || birthday.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
	}

	public int age() {
		return Period.between(this.birthday, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return this.name + " " + this.lastName + " (turns " + (age()+1) + ")";
	}
}

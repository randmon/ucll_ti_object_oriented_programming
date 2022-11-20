package student_app.ui;

import student_app.domain.Student;
import student_app.domain.StudentGroup;

public class StudentApp {

	/** Wanneer we deze app de eerste keer uitvoeren zal er 1 student in de groep zitten.
	 * Wanneer we de app nog een uitvoeren zal dezelfde student 2 keer in de groep zitten.
	 * De student is immers opgelagen in een geserialiseerd bestand bij de eerste afsluiting
	 * en wordt bij het opstarten de 2 de keer opnieuw ingelezen en aan de groep toegevoegd */
	public static void main(String[] args) {
		StudentGroup groep = StudentGroup.loadFromFile();

		if (groep == null) {
			groep = new StudentGroup("Informatica");
		}

//		groep.addStudent(new Student("Cristina","Marques"));
//		groep.addStudent(new Student("Astrid","Piot"));

		groep.removeAllStudents();

		groep.addStudent(new Student("Rudi","Swennen"));
		groep.addStudent(new Student("Kris","Keersmaekers"));
		groep.addStudent(new Student("Patrick","Star"));
		groep.addStudent(new Student("Bob","Sponge"));

		System.out.println(groep);

		groep.saveToFile();
	}
}

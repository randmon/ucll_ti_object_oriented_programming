package student_app.domain;
import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private final String name;
	private final String lastName;
	
	public Student (String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return name + " " + lastName;
	}

}

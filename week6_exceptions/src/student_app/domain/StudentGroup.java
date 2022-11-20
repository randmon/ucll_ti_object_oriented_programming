package student_app.domain;
import java.io.*;
import java.util.ArrayList;

public class StudentGroup implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	private final String name;
	private final ArrayList <Student> students;
	
	public StudentGroup(String name) {
		this.name = name;
		students = new ArrayList<>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeAllStudents() {
		students.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Group: " + name);
		for (Student student: students){
			sb.append("\n\t\t").append(student);
		}
		return sb.toString();
	}
	
	public void saveToFile() {
		File file = new File("week6_exceptions/src/student_app/domain/students.ser");
		try {
			file.createNewFile();
			FileOutputStream fileOutput = new FileOutputStream(file);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(this);
			objectOutput.flush();
			System.out.println("Group saved");
	   	} catch(IOException ioe){
			System.out.println("Error saving group: " + ioe.getMessage());
		}
	}
	
	public static StudentGroup loadFromFile() {
		StudentGroup group = null;
		File file = new File("week6_exceptions/src/student_app/domain/students.ser");
		try {
			file.createNewFile();
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
		    group = (StudentGroup) objectInput.readObject();
			System.out.println("Loaded group");
		} catch(IOException ioe){
			 System.out.println("Error loading group: " + ioe.getMessage());
		} catch(ClassNotFoundException c){
			System.out.println("Class not found");
			c.printStackTrace();
		}
		return group;
	}

}

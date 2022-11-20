package ui;

import domain.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        List<Person> p = loadFromFile("week8_jcf_list/peopleInfoInput.csv");
        p.forEach(System.out::println);
        Collections.sort(p);
        System.out.println("\n\nSorted:");
        p.forEach(System.out::println);
        saveToFile(p,"week8_jcf_list/peopleInfoOutput.csv");
    }

    private static List<Person> loadFromFile(String inputFile){
        List<Person> p = new ArrayList<>();

        try {
            File file = new File(inputFile);
            Scanner scanner = new Scanner(file);

            // First line is header
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] row = line.split(",");

                try {
                    int year = Integer.parseInt(row[2]);
                    int month = Integer.parseInt(row[3]);
                    int day = Integer.parseInt(row[4]);

                    Person person = new Person(row[0], row[1], LocalDate.of(year,month,day));
                    p.add(person);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number, skipping line");
                }
            }
        }  catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return p;
    }

    private static void saveToFile(List<Person> p, String outputFile){
        File output = new File(outputFile);
        try {
            PrintWriter writer = new PrintWriter(output);

            writer.println("Name,Lastname,Age");

            for (Person person: p){
                writer.println(person.getName() + "," + person.getLastName() + "," + person.getAge());
            }
            writer.close();
        }  catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}

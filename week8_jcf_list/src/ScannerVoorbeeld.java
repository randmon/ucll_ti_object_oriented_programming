import java.util.Scanner;

public class ScannerVoorbeeld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef je naam");
        String naam = scanner.nextLine();
        System.out.println("Hoe oud ben je?");
        int leeftijd = scanner.nextInt();
        System.out.println("Dag " + naam + " op je volgende verjaardag zal je "
                + (leeftijd + 1) + " jaar zijn.");
    }
}

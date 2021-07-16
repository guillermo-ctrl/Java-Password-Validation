import java.util.Scanner;

public class App {
    public static void main (String[] args) {

    Scanner inputField = new Scanner(System.in);
    System.out.println("Bitte geben Sie ein Passwort ein");

    String password = inputField.nextLine();

    if (Password.validatePassword(password)) {
        System.out.println("Password gültig.");
    } else {
        System.out.println("Password ist nicht komplex genug.");
    }
    }
}

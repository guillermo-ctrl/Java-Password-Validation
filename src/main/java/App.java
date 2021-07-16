import java.util.Scanner;

public class App {
    public static void main (String[] args) {

    Scanner inputField = new Scanner(System.in);

    boolean isPasswordValid = false;

    System.out.println("Bitte geben Sie ein Passwort ein");

    while(!isPasswordValid) {
        String password = inputField.nextLine();

        if (Password.validatePassword(password)) {
            System.out.println("Password gültig.");
            isPasswordValid = true;
        }
    }

    }
}

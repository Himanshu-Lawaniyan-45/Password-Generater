import java.util.*;

public class PasswordGenerator{

    static String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    static String NUMBERS = "0123456789";
    static String SYMBOLS = "!@#$%^&*()-_=+<>?/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter desired password length: ");
        int length = sc.nextInt();
        
        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = sc.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = sc.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = sc.next().equalsIgnoreCase("y");

        System.out.print("Include symbols? (y/n): ");
        boolean useSymbols = sc.next().equalsIgnoreCase("y");

        String password = generatePassword(length, useUpper, useLower, useNumbers, useSymbols);

        if (password.isEmpty()) {
            System.out.println("Error: No character sets selected.");
        } else {
            System.out.println("Generated Password: " + password);
        }

        sc.close();
    }

    public static String generatePassword(int length, boolean upper, boolean lower, boolean num, boolean sym) {
        StringBuilder allowedChars = new StringBuilder();
        Random rand = new Random();

        if (upper) allowedChars.append(UPPER_CASE);
        if (lower) allowedChars.append(LOWER_CASE);
        if (num) allowedChars.append(NUMBERS);
        if (sym) allowedChars.append(SYMBOLS);

        if (allowedChars.length() == 0) return "";

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }
}

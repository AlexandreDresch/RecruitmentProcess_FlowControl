package Application;

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Enter the first parameter:");
        int firstParam = terminal.nextInt();
        System.out.println("Enter the second parameter:");
        int secondParam = terminal.nextInt();

        try {
            count(firstParam, secondParam);
        } catch (InvalidParamsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void count(int firstParam, int secondParam) throws InvalidParamsException {
        if (firstParam > secondParam) {
            throw new InvalidParamsException("The second parameter must be greater than the first.");
        }

        int counting = secondParam - firstParam + 1;
        for (int i = 1; i <= counting; i++) {
            System.out.println("Printing number " + i);
        }
    }
}

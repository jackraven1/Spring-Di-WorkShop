package se.lexicon.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerInputService implements UserInputService {
    private final Scanner scanner;

    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter a string: ");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}

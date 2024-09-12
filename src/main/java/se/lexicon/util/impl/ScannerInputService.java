package se.lexicon.util.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {
    private Scanner scanner;

    // Constructor Injection
    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println("Enter id: ");
        return Integer.parseInt(scanner.nextLine());
    }
}

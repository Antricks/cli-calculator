package src;

import java.util.Scanner;

public class Calculator {
    Scanner scanner;
    
    Calculator() {
        this.scanner = new Scanner(System.in);
    }

    double calculate(String input) {
        return new Term(input).eval();
    }

    String nextLine() {
        return this.scanner.nextLine();
    }
}

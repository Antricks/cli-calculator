package src;

import java.util.Scanner;

public class Alleskoenner {
    Scanner scanner;
    
    Alleskoenner() {
        this.scanner = new Scanner(System.in);
    }
    
    boolean istSchaltjahr(int jahr) {
        return jahr % 4 == 0 && !(jahr % 100 == 0 && !(jahr % 400 == 0)); 
    }

    double taschenrechner(String eingabe) {
        return new Term(eingabe).eval();
    }

    String nextLine() {
        return this.scanner.nextLine();
    }
}

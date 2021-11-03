package src;

public class App {
    static Calculator calc;
    
    public static void main(String[] args) {
        calc = new Calculator();
        
        System.out.println("Welcome to my super awesome calculator. Here's a list of the supported operators:");
        System.out.println("+ - / * % ^");
        System.out.println("Furthermore you can use brackets. If you want to work with 'pi' or 'e', that's also no problem.");
        System.out.println("To quit, simply enter 'exit' or press Ctrl+C.");

        String input;

        while (true) {
            try {
                System.out.print("> ");
                input = calc.nextLine();
                if(input.contains("exit")) {
                    break;
                }
                System.out.println(calc.calculate(input));
            } catch (Exception e) {
                System.out.println("ERROR - please check your input.");
            }
        }

        System.out.println("bye!");
    }   
}

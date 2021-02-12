package src;

public class App {
    static Alleskoenner alleskoenner;
    
    public static void main(String[] args) throws Exception {
        alleskoenner = new Alleskoenner();
        
        System.out.println("Willkommen bei meinem super tollen Taschenrechner. Unterstützt sind folgende Operatoren:");
        System.out.println("+ - / * % ^");
        System.out.println("Des Weiteren kannst du auch gewöhnliche Klammern also '(' bzw ')' verwenden.");
        System.out.println("Außerdem kannst du 'pi' oder 'e' verwenden, Groß-/Kleinschreibung ist da egal.");
        System.out.println("Mit 'exit' kannst du das Programm beenden.");

        String input;

        while (true) {
            try {
                System.out.print("> ");
                input = alleskoenner.nextLine();
                if(input.contains("exit")) {
                    System.out.println("Tschüssi!");
                    break;
                }
                System.out.println(alleskoenner.taschenrechner(input));
            } catch (Exception e) {
                System.out.println("FEHLER - überprüfe deine Eingabe.");
            }
        }
    }   
}

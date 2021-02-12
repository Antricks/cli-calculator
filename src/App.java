package src;

public class App {
    static Alleskoenner alleskoenner;
    
    public static void main(String[] args) throws Exception {
        alleskoenner = new Alleskoenner();
        
        System.out.println("Willkommen bei meinem super tollen Taschenrechner. Unterstützt sind folgende Operatoren:");
        System.out.println("+ - / * % ^");
        System.out.println("Außerdem kannst du 'pi' oder 'e' verwenden, Groß-/Kleinschreibung ist egal.");
        System.out.println("Klammern werden leider noch nicht unterstützt.");

        while (true) {
            try {
                System.out.print("> ");
                System.out.println(alleskoenner.taschenrechner(alleskoenner.nextLine()));    
            } catch (Exception e) {
                System.out.println("FEHLER - überprüfe deine Eingabe.");
            }
        }
    }   
}

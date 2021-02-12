package src;

public class Equation {
    static char[] OPERANDS = {'+', '-', '*', '/', '^', '%'};

    Equation a;
    Equation b;
    char operand;

    double constant;

    Equation(String inputEquation) {

        int in_brackets = 0;
        
        int bracket_count = 0;

        for (char c : inputEquation.toCharArray()) {
            if(c == '(') {
                bracket_count++;
            }
        }

        boolean last_brackets = (bracket_count == 1 && inputEquation.strip().toCharArray()[0] == '(' && inputEquation.strip().toCharArray()[inputEquation.strip().length()-1] == ')');

        if (last_brackets) {
            inputEquation = inputEquation.replaceAll("\\(", "").replaceAll("\\)", "");
        }

        for (char operand : OPERANDS) {

            if(inputEquation.contains(String.valueOf(operand))) {                
            
                char c;

                for (int i = 0; i < inputEquation.toCharArray().length; i++) {
                    
                    c = inputEquation.toCharArray()[i];

                    if(c == '(') {
                        in_brackets++;
                    } else if (c == ')') {
                        in_brackets--;
                    }

                    if(c == operand && !(in_brackets > 0 && !last_brackets)) {
            
                        String input_a = inputEquation.substring(0, i);
                        String input_b = inputEquation.substring(i+1, inputEquation.length());

                        this.a = new Equation(input_a);
                        this.b = new Equation(input_b);
                        this.operand = operand;

                        return;
                    }
                }
            }
        }

        if (inputEquation.strip().equalsIgnoreCase("pi")) {
            this.constant = Math.PI;
        } else if (inputEquation.strip().equalsIgnoreCase("e")) {
            this.constant = Math.E;
        } else {
            this.constant = Double.parseDouble(inputEquation.strip());
        }
    }

    public double eval() {
        if(operand == '+') {
            return a.eval() + b.eval();
        } else if (operand == '-') {
            return a.eval() - b.eval();
        } else if (operand == '*') {
            return a.eval() * b.eval();
        } else if (operand == '/') {
            return a.eval() / b.eval();
        } else if (operand == '^') {
            return Math.pow(a.eval(), b.eval());
        } else if (operand == '%') {
            return a.eval() % b.eval();
        } else {
            return constant;
        }
    }
}
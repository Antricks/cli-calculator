package src;

public class Term {
    static char[] OPERANDS = {'+', '-', '*', '/', '^', '%'};

    Term a;
    Term b;
    char operand;

    double constant;

    Term(String inputTerm) {

        int in_brackets = 0;
        
        int bracket_count = 0;

        for (char c : inputTerm.toCharArray()) {
            if(c == '(') {
                bracket_count++;
            }
        }

        boolean last_brackets = (bracket_count == 1 && inputTerm.strip().toCharArray()[0] == '(' && inputTerm.strip().toCharArray()[inputTerm.strip().length()-1] == ')');

        if (last_brackets) {
            inputTerm = inputTerm.replace("(", "").replace(")", "");
        }

        for (char operand : OPERANDS) {

            if(inputTerm.contains(String.valueOf(operand))) {                
            
                char c;

                for (int i = 0; i < inputTerm.toCharArray().length; i++) {
                    
                    c = inputTerm.toCharArray()[i];

                    if(c == '(') {
                        in_brackets++;
                    } else if (c == ')') {
                        in_brackets--;
                    }

                    if(c == operand && !(in_brackets > 0 && !last_brackets)) {
            
                        String input_a = inputTerm.substring(0, i);
                        String input_b = inputTerm.substring(i+1, inputTerm.length());

                        this.a = new Term(input_a);
                        this.b = new Term(input_b);
                        this.operand = operand;

                        return;
                    }
                }
            }
        }

        if (inputTerm.strip().equalsIgnoreCase("pi")) {
            this.constant = Math.PI;
        } else if (inputTerm.strip().equalsIgnoreCase("e")) {
            this.constant = Math.E;
        } else {
            this.constant = Double.parseDouble(inputTerm.strip());
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
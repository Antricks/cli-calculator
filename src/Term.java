package src;

public class Term {
    static char[] OPERATORS = {'+', '-', '*', '/', '^', '%'};

    Term a;
    Term b;
    char operator;

    double constant;

    Term(String inputTerm) {

        int inBrackets = 0;
        
        int bracketCount = 0;

        for (char c : inputTerm.toCharArray()) {
            if(c == '(') {
                bracketCount++;
            }
        }

        boolean lastBrackets = (bracketCount == 1 && inputTerm.strip().toCharArray()[0] == '(' && inputTerm.strip().toCharArray()[inputTerm.strip().length()-1] == ')');

        if (lastBrackets) {
            inputTerm = inputTerm.replace("(", "").replace(")", "");
        }

        for (char op : OPERATORS) {

            if(inputTerm.contains(String.valueOf(op))) {                
            
                char c;

                for (int i = 0; i < inputTerm.toCharArray().length; i++) {
                    
                    c = inputTerm.toCharArray()[i];

                    if(c == '(') {
                        inBrackets++;
                    } else if (c == ')') {
                        inBrackets--;
                    }

                    if(c == op && !(inBrackets > 0 && !lastBrackets)) {
            
                        String inputA = inputTerm.substring(0, i);
                        String inputB = inputTerm.substring(i+1, inputTerm.length());

                        this.a = new Term(inputA);
                        this.b = new Term(inputB);
                        this.operator = op;

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
        if(operator == '+') {
            return a.eval() + b.eval();
        } else if (operator == '-') {
            return a.eval() - b.eval();
        } else if (operator == '*') {
            return a.eval() * b.eval();
        } else if (operator == '/') {
            return a.eval() / b.eval();
        } else if (operator == '^') {
            return Math.pow(a.eval(), b.eval());
        } else if (operator == '%') {
            return a.eval() % b.eval();
        } else {
            return constant;
        }
    }
}
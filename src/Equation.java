package src;

import java.util.regex.Pattern;

public class Equation {
    static char[] OPERANDS = {'+', '-', '*', '/', '^', '%'};

    Equation a;
    Equation b;
    char operand;

    double constant;

    Equation(String inputEquation) {
        for (char operand : OPERANDS) {
            if(inputEquation.contains(String.valueOf(operand))) {
                String[] input_split = inputEquation.split(Pattern.quote(String.valueOf(operand)), 2);
                
                this.a = new Equation(input_split[0]);
                this.b = new Equation(input_split[1]);
                this.operand = operand;

                return;
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
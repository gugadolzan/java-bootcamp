package br.com.dh.testing01.calculator;

public class Calculator {

    public double sum(double n1, double n2) {
        return n1 + n2;
    }

    public double divide(double n1, double n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }
}

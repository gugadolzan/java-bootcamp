package br.com.dh.testing03.util;

// Singleton
public class NumberGenerator {

    private int nextNumber;
    private static final NumberGenerator instance = new NumberGenerator();

    private NumberGenerator() {}

    public static NumberGenerator getInstance() {
        return instance;
    }

    public int getNextNumber() {
        return ++nextNumber;
    }
}

package com.javafundamentals.calcengine;

public interface MathProcessing {
    String SEPAREATOR = " ";
    String getKeyword(); // add
    char getSymbol(); // +

    double doCalculation(double leftVal, double rightVal);
}

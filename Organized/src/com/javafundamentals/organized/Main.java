package com.javafundamentals.organized;

public class Main {

    public static void main(String[] args) {
        Integer a = 100;
        int b = a;
        Integer c = b;

        Integer d = Integer.valueOf(100);
        int e  = d.intValue();

        String s = "87.44";
        double s1 = Double.parseDouble(s);
        Double s2 = Double.valueOf(s);

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("e: " + e);


    }
}

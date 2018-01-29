package com.javafundamentals.classinheritance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = null;
        int total = 0;
        try {
            reader = new BufferedReader(new FileReader("D:\\Dev\\Java\\ErrorHandling\\src\\com\\javafundamentals\\classinheritance\\Numbers.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                total += Integer.valueOf(line); // String into a number
            }
            System.out.println("Total: " + total);
        } catch (NumberFormatException e) { // RuntimeException unchecked
            System.out.println("Invalid value: " + e.getMessage());
        } catch (FileNotFoundException e) { // inherit from IOException
            System.out.println("Not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error interacting with file: " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}


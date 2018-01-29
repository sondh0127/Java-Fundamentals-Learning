package com.javafundamentals.myapp;

import com.javafundamentals.calcengine.Adder;
import com.javafundamentals.calcengine.CalculateBase;
import com.javafundamentals.calcengine.CalculateHelper;
import com.javafundamentals.calcengine.Divider;
import com.javafundamentals.calcengine.DynamicHelper;
import com.javafundamentals.calcengine.InvalidStatementException;
import com.javafundamentals.calcengine.MathEquation;
import com.javafundamentals.calcengine.MathProcessing;
import com.javafundamentals.calcengine.Multiplier;
import com.javafundamentals.calcengine.PowerOf;
import com.javafundamentals.calcengine.Subtractor;

public class Main {

    public static void main(String[] args) {
//    useCalculateHelper();
        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"         //5.0 ^ 2.0 = 25.0
        };
        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });
        for (String statement : statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }

    }

    static void useCalculateHelper() {
        //        MathEquation testEquation  = new MathEquation();
//        testEquation.execute();
//        System.out.print("test = ");
//        System.out.println(testEquation.getResult());

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation(100.0d, 50.0d, 'd');
        equations[1] = new MathEquation(25.0d, 92.0d, 'a');
        equations[2] = new MathEquation(225.0d, 17.0d, 's');
        equations[3] = new MathEquation(11.0d, 3.0d, 'm');

//        equations[0] = create(100.0d, 50.0d, 'd');
//        equations[1] = create(25.0d, 92.0d, 'a');
//        equations[2] = create(225.0d, 17.0d, 's');
//        equations[3] = create(11.0d, 3.0d, 'm');
        for (MathEquation equation :
                equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Overloading!");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        System.out.println();
        System.out.println("Overloading with integer!");
        System.out.println();
        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.print("result = ");
        System.out.println((int) equationOverload.getResult());

        System.out.println();
        System.out.println("Using Inheritance!");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d),
        };

        for (CalculateBase cal :
                calculators) {
            cal.calculate();
            System.out.print("result = ");
            System.out.println(cal.getResult());
        }

        System.out.println();
        System.out.println("Using more data type capabilities!");
        System.out.println();

        String[] statements = {
                "add 1.0",      // error: incorrect number of values
                "add xx 25.0",  // error: non-numeric data
                "addX 0.0 0.0", // error: invalid command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper calculateHelper = new CalculateHelper();

        for (String statement : statements) {
            try {
                calculateHelper.process(statement);
                System.out.println(calculateHelper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out .println("   - Original exception: " + e.getCause().getMessage());
            }
        }

    }
    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }

}

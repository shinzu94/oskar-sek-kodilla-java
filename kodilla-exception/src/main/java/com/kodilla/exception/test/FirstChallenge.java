package com.kodilla.exception.test;

import java.util.Arrays;

public class FirstChallenge {
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            Double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException exception) {
            System.out.println("\nException: " + exception);
            System.out.println("\nMessage: " + exception.getMessage());
            System.out.println("\nShort stacktrace:");
            Arrays.stream(exception.getStackTrace())
                    .limit(5)
                    .map(trace -> trace.getClassName() + " method " +
                            trace.getMethodName() +
                            " line " + trace.getLineNumber())
                    .forEach(System.out::println);
        } finally {
            System.out.println("\nAnd Finally, the application ends.");
        }
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("You can't divide by 0.");
        }

        return a / b;
    }
}

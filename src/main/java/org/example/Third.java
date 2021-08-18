package org.example;

import java.math.BigInteger;

public class Third {

    private static int NUMBER_FACTORIAL = 100;

    public static void main(String[] args) {
        new Third().run();
    }

    private void run() {
        //Find the factorial
        BigInteger f = getFactorial(NUMBER_FACTORIAL);
        //Convert to String and found the sum numbers
        long s = sum(f.toString());
        System.out.println(s);
    }

    /*
        Find the factorial of a given number
     */
    private BigInteger getFactorial(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        BigInteger f = BigInteger.ONE;
        for (long i = 2; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    /*
        Find the sum of the numbers in the string
     */
    private long sum(String textFactorial) {
        long s = 0;
        for (int i = 0; i < textFactorial.length(); i++) {
            s += Character.getNumericValue(textFactorial.charAt(i));
        }
        return s;
    }


}

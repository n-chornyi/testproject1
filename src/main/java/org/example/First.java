package org.example;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        new First().run();
    }

    private void run() {

        Scanner scanner = new Scanner(System.in);
        try {
            //Read number from keyboard
            int N = scanner.nextInt();
            //Find the number of Catalan
            System.out.println(count(N));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
        Find the number of Catalan by the formula
     */
    private long count(int n){
        long[] c = new long[n+1];
        c[0] = 1;
        for (int i = 1; i <= n; i++) {
            c[i] = 0;
            for (int j = 0; j < i; j++) {
                c[i] += c[j]*c[i-1-j];
            }
        }
        return c[n];
    }
}

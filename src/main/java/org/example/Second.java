package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second {

    private static final int LOCAL_VARIABLE = 999999999;

    public static void main(String[] args) {
        new Second().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            //Input count tests
            int s = scanner.nextInt();
            if (s > 10 || s < 1) {
                throw new Exception("Error input, should be from 1 to 10");
            }
            //Input count cities
            int n = scanner.nextInt();
            if (n > 10000 || n < 1) {
                throw new Exception("Error input, should be from 1 to 10000");
            }
            //Generate matrix
            int[][] matrix = generateMatrix(n);
            //List cities
            List<String> city_names = new ArrayList<>();

            for (int test = 0; test < s; test++) {
                for (int i = 0; i < n; i++) {
                    //Input city
                    String cityName = scanner.next().strip();
                    city_names.add(cityName);
                    //Input the number of neighbors of city
                    int p = scanner.nextInt();
                    if (p > n || p < 1) {
                        throw new Exception("Error input, should be from 1 to " + n);
                    }

                    //Input nr - index of a city connected to NAME (the index of the first city is 1)]
                    //      cost - the transportation cost
                    for (int j = 0; j < p; j++) {
                        int nr = Integer.parseInt(scanner.next())-1;
                        int cost = Integer.parseInt(scanner.next());
                        matrix[i][nr] = cost;
                    }

                }
                matrix = floyd(matrix, n);

                //Input the number of paths to find
                int r = scanner.nextInt();
                if (r < 1 || r > 100) {
                    throw new Exception("Error input, should be from 1 to 100");
                }

                //Input start & end cities
                int[] result = new int[r];
                for (int j=0; j<r; j++) {
                    String start = scanner.next();
                    String end = scanner.next();
                    int start_number = city_names.indexOf(start);
                    int end_number = city_names.indexOf(end);
                    result[j] = matrix[start_number][end_number];
                }

                for (int j=0; j<result.length; j++) {
                    System.out.println(result[j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Generate new matrix
    private int[][] generateMatrix(int n) {
        int[][] temp = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                temp[i][j] = LOCAL_VARIABLE;
            }
        }
        return temp;
    }

    //Sorting for algorithm Floyd
    private int[][] floyd(int[][] temp, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][k] != LOCAL_VARIABLE & temp[k][j] != LOCAL_VARIABLE) {
                        if ((temp[i][k] + temp[k][j]) <= temp[i][j]) {
                            temp[i][j] = temp[i][k] + temp[k][j];
                        }
                    }
                }
            }
        }
        return temp;
    }
}

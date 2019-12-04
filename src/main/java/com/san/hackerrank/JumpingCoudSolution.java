package com.san.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JumpingCoudSolution {
    static int jumpingOnClouds(int[] c) {
        int jumpCount = 0;
        for (int i = 0; i < c.length - 1;) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i = i + 2;
                jumpCount++;
            } else {
                i = i + 1;
                jumpCount++;
            }
        }
        return jumpCount;
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds1(int[] c) {
        final List<Integer> path1 = new ArrayList<>();
        final List<Integer> path2 = new ArrayList<>();
        final int countSingleJump = 0;
        final int countDoubleJump = 0;
        path1.add(0);
        path2.add(0);
        for (int i = 0; i < c.length - 1;) {
            if (path1.indexOf(i) != -1) {
                if (isValid(c, i, 1)) {
                    i = i + 1;
                    path1.add(i);
                }
                if (path1.indexOf(i) != -1 && isValid(c, i, 2)) {
                    i = i + 2;
                    path1.add(i);
                }
            }

            if (path2.indexOf(i) != -1) {
                if (isValid(c, i, 1)) {
                    i = i + 1;
                    path2.add(i);
                }
                if (path2.indexOf(i) != -1 && isValid(c, i, 2)) {
                    i = i + 2;
                    path2.add(i);
                }
            }
        }
        return path1.size() < path2.size() ? path1.size() : path2.size();
    }

    private static boolean isValid(int[] c, int index, int offset) {

        return index + offset < c.length && c[index + offset] == 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final int[] c = new int[n];

        final String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            final int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        final int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}

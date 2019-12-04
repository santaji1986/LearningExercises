package com.san.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountingValleysSolution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        final List<Character> valleySteps = new ArrayList<>(n);
        final List<Character> mountainSteps = new ArrayList<>(n);
        int seaLevel = 0;
        boolean isValleyStart = false;
        for (final char step : s.toCharArray()) {
            if (step == 'U') {
                if (valleySteps.size() > 0) {
                    valleySteps.remove(valleySteps.size() - 1);
                } else {
                    mountainSteps.add(step);
                }
                seaLevel++;
            } else {
                if (mountainSteps.size() > 0) {
                    mountainSteps.remove(mountainSteps.size() - 1);
                } else {
                    valleySteps.add(step);
                }
                seaLevel--;
            }
            if (seaLevel < 0 && !isValleyStart) {
                valleyCount++;
                isValleyStart = true;
            }
            if (seaLevel == 0) {
                isValleyStart = false;
            }

        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final String s = scanner.nextLine();

        final int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

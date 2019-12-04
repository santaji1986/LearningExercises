package com.san.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SockPairMatchSolution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairCount = 0;
        final List<Integer> listPair = new ArrayList<>(ar.length);
        for (final int i : ar) {
            final int index = listPair.indexOf(i);
            if (-1 != index) {
                listPair.remove(index);
                pairCount++;
            } else {
                listPair.add(i);
            }
        }
        return pairCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final int[] ar = new int[n];

        final String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            final int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        final int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}

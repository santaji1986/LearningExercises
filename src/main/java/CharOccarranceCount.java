import java.io.IOException;
import java.util.Scanner;

public class CharOccarranceCount {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        String temp = "";
        long count = 0;
        if (s.contains("a")) {
            while (temp.length() <= n) {
                temp = temp + s;
            }
            if (temp.length() > n) {
                temp = temp.substring(0, (int) n);
            }
            System.out.println("CharOccarranceCount.repeatedString() " + temp);
            final char[] charArray = temp.toCharArray();
            for (final char c : charArray) {
                if (c == 'a') {
                    count++;
                }
            }
        }
        return count;
    }

    static long repeatedStringNEW(String s, long n) {
        String temp = "";
        final long minCount = getCount(s, 'a');

        long multipleFactor = 0;
        long remainingFactor = 0;

        if (s.length() < n) {
            multipleFactor = n / s.length();
            remainingFactor = n % s.length();
        } else {
            remainingFactor = n % s.length();
        }
        temp = s.substring(0, (int) remainingFactor);
        final long remainingCount = getCount(temp, 'a');
        return minCount * multipleFactor + remainingCount;
    }

    private static long getCount(String s, char pivotChar) {
        int count = 0;
        final char[] charArray = s.toCharArray();
        for (final char c : charArray) {
            if (c == pivotChar) {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        final String s = scanner.nextLine();

        final long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        final long result = repeatedString(s, n);
        // final long result = repeatedStringNEW(s, n);
        System.out.println("CharOccarranceCount.main() " + String.valueOf(result));
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();
        //
        // bufferedWriter.close();

        scanner.close();
    }

}

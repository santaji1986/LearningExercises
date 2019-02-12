import java.util.HashMap;
import java.util.Map;

class PerfectSquare {

    public static void main(String[] args) {
        final PerfectSquare s = new PerfectSquare();
        // s.solution(6000, 7000);
        // s.solution(10, 20);
        s.findIndivisibleSQRTNumber(6000, 7000);

    }

    public int solution(int A, int B) {
        // write your code in Java SE 8
        int maxCount = 0;
        boolean isPerfect;
        int resultedNumber = 0;
        int testNumber = 0; // just holding copy of iterating number

        for (int i = A; i <= B; i++) {

            isPerfect = true;
            int counter = 0;
            testNumber = i;

            while (isPerfect) {
                isPerfect = isPerfectNumer(testNumber);
                System.out.println("Test square number:  " + testNumber + "is Perfect " + isPerfect);

                if (isPerfect == true) {
                    counter++;
                    System.out.println("Perfect square number:  " + testNumber);
                    if (counter > maxCount) {
                        // resultedNumber = (int) Math.sqrt(testNumber);
                        maxCount = counter;
                        testNumber = (int) Math.sqrt(testNumber);
                        resultedNumber = testNumber;
                    }
                } else {
                    isPerfect = false; // might be redundant
                    break;
                }

                System.out.println("Max square number:  " + resultedNumber);
                // if(testNumber == 1){
                // break;
                // }
                //
            }

        }
        return resultedNumber;
    }

    public Boolean isPerfectNumer(int number) {
        boolean isPerfectSquare = false;
        if (0 == number || 1 == number) {
            isPerfectSquare = false;
        } else {

            final int result = (int) Math.sqrt(number);

            if (result * result == number) {
                isPerfectSquare = true;
            }
        }
        return isPerfectSquare;
    }

    private int countLevel = 0;

    public void findIndivisibleSQRTNumber(int start, int end) {
        final Map<Integer, Integer> map = new HashMap<>();

        int resultNumber = 0;
        for (int i = start; i <= end; i++) {
            countLevel = 0;
            resultNumber = getIndivisibleSQRTNumber(i);

            System.out.println("resultNumber : " + resultNumber + " countLevel : " + countLevel);
            if (countLevel != 0) {
                map.put(resultNumber, countLevel);
            }
        }
        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Lowest indivisible number : " + entry.getKey() + " Level : " + entry.getValue());
        }
    }

    public int getIndivisibleSQRTNumber(int number) {
        if (isPerfectNumer(number)) {
            countLevel++;
            return getIndivisibleSQRTNumber((int) Math.sqrt(number));
        } else {
            return number;
        }
    }

}

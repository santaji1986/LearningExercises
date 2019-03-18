import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class PerfectSquare {

    public static void main(String[] args) {
        final PerfectSquare s = new PerfectSquare();

        // s.solution(6000, 7000); // 1st approach
        // s.solution(10, 20);
        s.findIndivisibleSQRTNumber(1, 1000); // 2nd approach

        // System.out.println(s.getMaxLevelMinIndivisibleNumber(map));

    }

    private Map.Entry<Integer, Integer> getMaxLevelMinIndivisibleNumber(Map<Integer, Integer> map) {

        Map.Entry<Integer, Integer> maxEntry = null;
        for (final Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (null == maxEntry) {
                maxEntry = entry;
            }
            if (entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            } else if (entry.getValue() == maxEntry.getValue()) {
                if (entry.getKey() < maxEntry.getKey()) {
                    maxEntry = entry;
                }
            }
        }
        System.out.println("maxEntry : " + maxEntry);
        return maxEntry;
    }

    public int solution(int A, int B) {
        // write your code in Java SE 8
        int maxCount = 0;
        boolean isPerfect;
        int resultedNumber = 0;
        int testNumber = 0; // just holding copy of iterating number
        int testNumberprev = Integer.MAX_VALUE;

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
                        if (testNumberprev > testNumber) {
                            testNumberprev = testNumber;
                        }
                    }
                } else {
                    isPerfect = false; // might be redundant
                    break;
                }
            }
        }
        System.out.println("Max square number:  " + testNumberprev);
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
        final Map<Integer, Integer> map = getMapOfElementAndLevelCount(start, end);

        int minNumber = 0;
        final Entry<Integer, Integer> entry = getMaxLevelMinIndivisibleNumber(map);
        if (null != entry) {
            minNumber = entry.getKey();
        }
        System.out.println("Max level min indivisible number:  " + minNumber);
    }

    private Map<Integer, Integer> getMapOfElementAndLevelCount(int start, int end) {
        int resultNumber = 0;
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = start; i <= end; i++) {
            countLevel = 0;
            resultNumber = getIndivisibleSQRTNumber(i);
            System.out.println("resultNumber : " + resultNumber + " countLevel : " + countLevel);

            if (countLevel != 0) {
                map.put(resultNumber, countLevel);
            }
        }
        System.out.println("MAP : " + map);
        return map;
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

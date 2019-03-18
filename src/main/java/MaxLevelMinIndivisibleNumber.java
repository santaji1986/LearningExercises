import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxLevelMinIndivisibleNumber {
    public MaxLevelMinIndivisibleNumber() {
    }

    public Integer getElementBasedOnMaxLevel(Map<Integer, Integer> inputMap) {
        Integer number = null;
        final Entry<Integer, Integer> entry = getMaxLevelMinIndivisibleNumber(inputMap);
        if (null != entry) {
            number = entry.getKey();
        }
        return number;
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

    public static void main(String[] args) {
        final MaxLevelMinIndivisibleNumber maxLevelMinIndivisibleNumber = new MaxLevelMinIndivisibleNumber();
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(7, 3);

        System.out.println(maxLevelMinIndivisibleNumber.getMaxLevelMinIndivisibleNumber(map));
    }
}

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class PerfectSquareTest {

    private MaxLevelMinIndivisibleNumber tdd;

    @Before
    public void init() {
        tdd = new MaxLevelMinIndivisibleNumber();
    }

    @Test
    public void givenMapwithData_getElementBasedOnMaxLevel_shouldRetuenLowestNumber() {

        final Map<Integer, Integer> inputMap = new HashMap<>();
        inputMap.put(1, 1);
        inputMap.put(2, 2);
        assertEquals(new Integer(2), tdd.getElementBasedOnMaxLevel(inputMap));

    }

    @Test
    public void givenMapwithData_getElementBasedOnMaxLevel_shouldRetuenEmpty() {

        final Map<Integer, Integer> inputMap = new HashMap<>();
        assertEquals(null, tdd.getElementBasedOnMaxLevel(inputMap));

    }

    @Test
    public void givenMapwithData_getElementBasedOnMaxLevel_shouldRetuenLowestNumber_WhenLevelNumberDuplicate() {

        final Map<Integer, Integer> inputMap = new HashMap<>();
        inputMap.put(1, 1);
        inputMap.put(2, 2);
        inputMap.put(3, 3);
        inputMap.put(7, 3);
        assertEquals(new Integer(3), tdd.getElementBasedOnMaxLevel(inputMap));

    }

}

package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Q30_FindGreatestSumOfSubArrayTest {

    @Test
    public void test(){
        Q30_FindGreatestSumOfSubArray q30_findGreatestSumOfSubArray = new Q30_FindGreatestSumOfSubArray();
        int[] array = {1, -2, 3, 10, -4, 7, 2};
        int expectedValue = 18;
        int actualValue = q30_findGreatestSumOfSubArray.findGreatestSumOfSubArray(array);
        Assertions.assertEquals(expectedValue, actualValue, "output error");
    }

}

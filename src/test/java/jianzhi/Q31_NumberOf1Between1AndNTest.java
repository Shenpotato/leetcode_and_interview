package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized;

public class Q31_NumberOf1Between1AndNTest {

    @Test
    public void test(){
        Q31_NumberOf1Between1AndN q31_numberOf1Between1AndN = new Q31_NumberOf1Between1AndN();
        int n = 5;
        int actualValue = q31_numberOf1Between1AndN.numberOf1Between1AndN(5);
        int expectedValue = 1;
        Assertions.assertEquals(expectedValue, actualValue);
    }
}

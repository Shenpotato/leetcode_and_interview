package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Q33_GetUglyNumberTest {

    Q33_GetUglyNumber q33_getUglyNumber;

    @BeforeEach
    public void beforeEachTest(){
        q33_getUglyNumber = new Q33_GetUglyNumber();
    }

    @Test
    public void testIsUglyNumber(){
        boolean actualValue = q33_getUglyNumber.isUglyNumber(6);
        boolean expectedValue = true;
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetUglyNumber(){
        int actualValue = q33_getUglyNumber.getUglyNumber(11);
        int expectedValue = 15;
        Assertions.assertEquals(expectedValue, actualValue);
    }

}

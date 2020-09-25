package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Q65_MovingCountTest {

    Q65_MovingCount q65_movingCount;

    @BeforeEach
    public void initialization() {
        q65_movingCount = new Q65_MovingCount();
    }


    @Test
    public void testCompute() {
        int actualValue = q65_movingCount.compute(12, 23);
        int expectedValue = 8;
        Assertions.assertEquals(expectedValue,actualValue);
    }
}

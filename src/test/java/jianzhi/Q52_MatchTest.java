package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q52_MatchTest {
    @Test
    public void test(){
        Q52_Match q52_match = new Q52_Match();
        char[] str = {'a','a','a'};
        char[] pattern = {'a','.','a'};
        boolean actualValue = q52_match.match(str, pattern);
        boolean expectedValue = true;

        Assertions.assertEquals(expectedValue,actualValue);
    }
}

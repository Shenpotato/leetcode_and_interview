package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Q41_FindContinuousSequenceTest {
    @Test
    public void test(){
        Q41_FindContinuousSequence q41_findContinuousSequnce = new Q41_FindContinuousSequence();
        int sum = 25;
        ArrayList<ArrayList<Integer>> expectedValue = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        expectedValue.add(list);
        list= new ArrayList<>();
        list.add(12);
        list.add(13);
        Integer []expectedArray = (Integer[]) expectedValue.toArray();
        Integer []acutalArray = (Integer[]) q41_findContinuousSequnce.findContinuousSequence1(sum).toArray();
        Assertions.assertArrayEquals(expectedArray,acutalArray);

    }
}

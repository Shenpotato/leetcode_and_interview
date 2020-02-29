package jianzhi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q35_InversePairsTest {

    @Test
    public void testMergeSort(){
        Q35_InversePairs q35_inversePairs = new Q35_InversePairs();
        int[] array = {4,2,5,3,1,6};
        int[] expectedArray = {1,2,3,4,5,6};
        q35_inversePairs.mergeSort(array, 0, array.length-1);
        Assertions.assertArrayEquals(expectedArray, array);
    }
}

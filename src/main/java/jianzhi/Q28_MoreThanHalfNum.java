package jianzhi;

import java.util.HashMap;
import java.util.Map;

/*
 * 数组中出现次数超过一般
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * */
public class Q28_MoreThanHalfNum {
    public int moreThanHalfNum(int[] array) {
        if(array.length == 0) return 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(array[i])) hashMap.put(array[i], hashMap.get(array[i]) + 1);
            else hashMap.put(array[i], 1);
        }
        int maxnum = 0, maxindex = array[0];
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (map.getValue() > maxnum) {
                maxnum = map.getValue();
                maxindex = map.getKey();
            }
        }
        if(maxnum > array.length / 2)
            return maxindex;
        return 0;
    }

}

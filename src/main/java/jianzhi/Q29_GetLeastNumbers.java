package jianzhi;

import java.util.ArrayList;

/*
* 最小的k个数
*
* 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * */
public class Q29_GetLeastNumbers {
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<>();
        if(input.length == 0 || k > input.length) return leastNumbers;
        // 对数组进行前k次选择排序
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if(input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
            leastNumbers.add(input[i]);
        }
        return leastNumbers;
    }

}

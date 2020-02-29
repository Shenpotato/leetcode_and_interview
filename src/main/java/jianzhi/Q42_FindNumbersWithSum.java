package jianzhi;

import java.util.ArrayList;

/*
 * 和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * */
public class Q42_FindNumbersWithSum {
    // 两次循环的方法
    public ArrayList<Integer> findNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array.length < 2) return result;
        for (int i = 0; i < array.length - 1; i++) {
            int diff = sum - array[i];
            if (diff > array[array.length - 1]) continue;
            for (int j = i; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    result.add(array[i]);
                    result.add(array[j]);
                    return result;
                }
            }
        }
        return result;
    }

    // 双指针
    public ArrayList<Integer> findNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length < 2) return list;
        int i = 0, j = array.length - 1;
        while (i < j) {
            int result = array[i] + array[j];
            if(result == sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }
            if(result < sum){
                i++;
                j = array.length-1;
            }
            else j--;
        }
        return list;
    }
}

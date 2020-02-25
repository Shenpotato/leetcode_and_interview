package jianzhi;

import java.util.Arrays;

/*
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
public class Q6_MinNumberInRotateArray {
    // 排序法, 时间复杂度O(NlogN)
    public int minNumberInRotateArray1(int[] array) {
        if (array.length == 0) return 0;
        Arrays.sort(array);
        return array[0];
    }

    // 顺序查找，时间复杂度O(N)
    public int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) return 0;
        int minNum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minNum) minNum = array[i];
        }
        return minNum;
    }

    // 二分查找。数组是半有序的
    public int minNumberInRotateArray3(int[] array) {
        if (array.length == 0) return 0;

        int lo = 0, hi = array.length - 1;

        while (array[lo] == array[hi]) {
            ++lo;
            --hi;
        }

        while (array[lo] > array[hi]) {
            int mid = lo + (hi - lo) / 2;

            if (array[mid] >= array[lo]) {
                lo = mid + 1;
            } else if (array[mid] <= array[hi]) {
                hi = mid;
            }
        }

        return array[lo];
    }
}

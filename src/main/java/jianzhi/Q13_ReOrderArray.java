package jianzhi;

import com.sun.tools.javac.util.ArrayUtils;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * */
public class Q13_ReOrderArray {

    // 借用辅助数组时间复杂度O(n)，空间复杂度O(n)
    public void reOrderArray1(int[] array) {
        int[] tempArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) tempArray[index++] = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) tempArray[index++] = array[i];
        }
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }

    // 使用两个指针，i指向偶数，j指向奇数，i-j之间的数组向后移一位，j的值置入i。
    public void reOrderArray2(int[] array) {
        int i = 0, j = 0;                          // i 记录偶数的位置，j记录偶数的位置
        while (i != array.length - 1 && j != array.length - 1) {
            while (array[i] % 2 != 0) i++;
            j = i + 1;
            while (array[j] % 2 != 1) j++;
            int temp = array[j];
            for (int k = j; k > i; k--) {
                array[k] = array[k - 1];
            }
            array[i] = temp;
        }
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }


    public void reOrderArray3(int[] array) {
        int formerOdd = 0, formerEven = 0;
        while(formerEven < array.length && formerOdd < array.length) {
            while (array[formerEven] % 2 != 0){
                if(formerEven == array.length -1) break;
                formerEven++;
            }
            formerOdd = formerEven + 1;
            while (array[formerOdd] % 2 != 1) {
                if(formerOdd > array.length-1) break;
                formerOdd++;
            }
            swapArray(array, formerEven, formerOdd);
            swap(formerEven, formerOdd);
        }
    }

    public void swapArray(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        Q13_ReOrderArray q13_reOrderArray = new Q13_ReOrderArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        q13_reOrderArray.reOrderArray2(array);
    }
}

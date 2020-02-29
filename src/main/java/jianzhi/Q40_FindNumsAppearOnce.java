package jianzhi;

import java.util.ArrayList;

/*
 * 数组中只出现一次的数
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * */
public class Q40_FindNumsAppearOnce {

    // Solu1：使用List保存出现一次的数
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length < 2) {
            return;
        }
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i])) {
                list.remove(new Integer(array[i]));
            } else {
                list.add(array[i]);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    // Solu2: 可以使用位操作。
    // 两个相同的数异或是0，0和任何数异或都是它本身
}

package jianzhi;

import java.util.ArrayList;

/*
 * 剪绳子
 *
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输入：8
 * 输出：18
 * */
public class Q66_CutRope {
    // 递归
    public int cutRope(int target) {
        return cutRope(target, 0);
    }

    public int cutRope(int target, int max) {
        int maxValue = max;
        for (int i = 1; i < target; i++) {
            maxValue = Math.max(i * cutRope(target - i, target - i), maxValue);
        }
        return maxValue;
    }

    //动态规划
    public int cutRope2(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;
        if (target == 4) return 4;

        ArrayList<Integer> list = new ArrayList() {{
            add(0);
            add(1);
            add(2);
            add(3);
            add(4);
        }};

        for (int j = 5; j <= target; j++) {     // 计算从1-target长度的max
            int max = 0;
            for (int i = 2; i <= j / 2; i++) {
                if (list.get(i) * list.get(target - i) > max) {
                    max = list.get(i) * list.get(target - i);
                }
            }
            list.add(max);
        }
        return list.get(target);
    }
}

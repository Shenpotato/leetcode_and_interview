package jianzhi;

/*
 * 连续子数组的最大和
 *
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * */
public class Q30_FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0];
        for (int i = 1; i <= array.length; i++) {        //窗口长度
            for (int j = 0; j <= array.length - i; j++) {
                maxSum = Math.max(sum(array, j, j + i), maxSum);
            }
        }
        return maxSum;
    }

    public int sum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    // 使用动态规划
    public int findGreatestSumOfSubArray2(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            array[i] += array[i - 1] > 0 ? array[i - 1] : 0;       // 当之前的累加和大于0时，继续加，如果小于0时则取当前数值
            max = Math.max(max, array[i]);
        }
        return max;
    }


}

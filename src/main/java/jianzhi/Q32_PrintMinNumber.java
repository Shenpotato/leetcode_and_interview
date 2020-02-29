package jianzhi;

/*
 * 把数组排成最小树
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * */
public class Q32_PrintMinNumber {
    public String printMinNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        String result = new String("");
        // 思路：S1 + S2 < S2 + S1, S1放在前面
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum1 = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int sum2 = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (sum1 > sum2) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        result += numbers[i];
        }
        return result;
    }

}

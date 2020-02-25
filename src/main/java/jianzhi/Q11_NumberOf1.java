package jianzhi;

/*
 * 二进制中 1 的个数
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * */
public class Q11_NumberOf1 {

    // 思路（抄的）：
    // 使用与运算。
    // 当一个数 n 表示为二进制位，其减一即 n-1 二进制的表示为从最后一位1开始进行与操作。
    // 如：1100 = 12 - 1 = 11 = 1011.
    // 利用这个特性：n & (n - 1) = 1000，一次与运算可消去一个二进制的 1。
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    // 一般思路：
    public int numberOf2(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    // java可转换为二进制字符串
    public int numberOf3(int n) {
        char[] numChars = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        if (numChars[0] == '-') {
            for (int i = 1; i < numChars.length; i++) {
                if(numChars[i] == '1') count++;
            }
        } else {
            for (int i = 0; i < numChars.length; i++) {
                if(numChars[i] == '1') count++;
            }
        }
        return count;
    }
}

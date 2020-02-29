package jianzhi;

/*
 * 丑树
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * */
public class Q33_GetUglyNumber {
    // 自己写的代码超时了
    public int getUglyNumber(int index) {
        int count = 0, number = 1;          //count 表示已经有多少个丑数，number表示递增的自然数
        while (count < index) {
            if (isUglyNumber(number)) count++;
            if (count != index) number++;
        }
        return number;
    }

    // 能被2 or 3 or 5 整除，是丑数
    public boolean isUglyNumber(int number) {
        if (number == 1) return true;
        int preNumber = number;
        while (true) {
            if (number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
                if (number % 2 == 0) number /= 2;
                if (number % 3 == 0) number /= 3;
                if (number % 5 == 0) number /= 5;
            }
            if (number == preNumber) {
                break;
            }
            preNumber = number;
        }
        if (number == 1) return true;
        return false;
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        int p2 = 0, p3 = 0, p5 = 0;//初始化三个指向三个潜在成为最小丑数的位置
        int[] result = new int[index];
        result[0] = 1;//
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            if (result[i] == result[p2] * 2) p2++;//为了防止重复需要三个if都能够走到
            if (result[i] == result[p3] * 3) p3++;//为了防止重复需要三个if都能够走到
            if (result[i] == result[p5] * 5) p5++;//为了防止重复需要三个if都能够走到
        }
        return result[index - 1];
    }
}

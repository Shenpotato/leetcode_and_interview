package jianzhi;

/*
 * 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * */
public class Q48_Add {
    // num1^num2是不带进位的结果，(num1&num2)<<1是进位的数
    public int add(int num1, int num2) {
//        int result = 0, carry = 0;
//        do {
//            result = num1 ^ num2;
//            carry = (num1 & num2) << 1;
//            num1 = result;
//            num2 = carry;
//        } while (carry != 0);
//        return result;
        return num2 != 0 ? add(num1 ^ num2, (num1 & num2) << 1) : num1;
    }
}

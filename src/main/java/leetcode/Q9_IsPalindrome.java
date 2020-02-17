package leetcode;

/*
* 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
输入: 121
输出: true

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

* */
public class Q9_IsPalindrome {
    //version one
    public boolean isPalindrome(int x) {
        // version one
//        char[] chars = String.valueOf(x).toCharArray();
//        int length = chars.length;
//        for (int i = 0; i < length / 2; i++) {
//            if (chars[i] != chars[length - i - 1]) {
//                return false;
//            }
//        }
//        return true;

        // version two
        if (x < 0) return false;
        int rev = 0;
        int old = x;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return false;
            rev = rev * 10 + pop;
        }
        if (rev == old) return true;
        return false;
    }

    public static void main(String[] args) {
        Q9_IsPalindrome q9_isPalindrome = new Q9_IsPalindrome();
        System.out.println(q9_isPalindrome.isPalindrome(121));
    }
}

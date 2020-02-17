package leetcode;

public class Q5_LongestPalindrome {
    public String longestPalindrome(String s) {
        String substring = null;
        int length = s.length();
        if(length == 0)
            return "";
        for (int i = length - 1; i > 0; i--) {    // 当前最大回文长度
            for (int j = 0; j < length - i; j++) {
//                System.out.println("i: " + i + " j: " + j);
                substring = s.substring(j, j + i + 1);
                System.out.println(substring);
                if (palindrome(substring.toCharArray())) {
                    return substring;
                }
            }
        }
        return s.substring(0,1);
    }

    public boolean palindrome(char[] chars) {
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q5_LongestPalindrome q5_longestPalindrome = new Q5_LongestPalindrome();
//        System.out.println(q5_longestPalindrome.palindrome("abba".toCharArray()));
        System.out.println(q5_longestPalindrome.longestPalindrome("cbbd"));
    }
}

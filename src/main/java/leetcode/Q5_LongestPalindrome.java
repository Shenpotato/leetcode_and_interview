package leetcode;

public class Q5_LongestPalindrome {
    public String longestPalindrome(String s) {
        String substring = null;
        int length = s.length();
        for (int i = length; i > 1; i--) {    // 当前最大回文长度
            for (int j = 0; j < length - i; j++) {
                substring = s.substring(j,j+i);
                if(palindrome(substring.toCharArray())){
                    break;
                }
            }
        }
        if(substring.length() == 1)
            return s.substring(0,1);
        return substring;
    }

    public boolean palindrome(char[] chars) {
        int length = chars.length;
        for (int i = 0; i < (length / 2 - 1); i++) {
            if (chars[i] != chars[length - i - 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q5_LongestPalindrome q5_longestPalindrome = new Q5_LongestPalindrome();
        System.out.println(q5_longestPalindrome.longestPalindrome("aba"));
    }
}

package leetcode;

// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//示例 1:
//输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。


import java.util.*;

public class Q3_LengthOfLongestSubstring {
    public boolean findreplicate(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        char[] chararrays = s.toCharArray();
        for (int i = 0; i < chararrays.length; i++) {
            if (hashMap.get(chararrays[i]) == null) {
                hashMap.put(chararrays[i], 1);
            } else {
                int num = hashMap.get(chararrays[i]);
                hashMap.put(chararrays[i], num + 1);
            }
        }
        for (int i : hashMap.values()) {
            if (i > 1) {
                return false;
            }
        }
        return true;
    }

    // 思路一：给定长度，截取字符串，观察其中是否有重复元素
    public int lengthOfLongestSubstring(String s) {
        int slength = s.length();
        if (slength == 1) {
            return 1;
        }
        for (int i = slength; i > 0; i--) {
            int j = slength - i;
            for (int m = 0; m < j; m++) {
                String substring = s.substring(m, m + i);
                if (findreplicate(substring)) {
                    return i;
                }
            }

        }
        return 0;
    }


    // 思路二：滑动窗口
    // 我们只需要对从每一个字符开始，最长能形成的连续字符串的长度进行比较
    // (a)bcabcbb 开始的最长字符串为 (abc)abcbb
    // a(b)cabcbb 开始的最长字符串为 a(bca)bcbb
    public int lengthOfLongestSubstring2(String s) {
        // 记录每个字符是否出现过
        Set<Character> occurs = new HashSet<>();
        int n = s.length();
        int rp = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occurs.remove(s.charAt(i - 1));
            }
            while (rp + 1 < n && !occurs.contains(s.charAt(rp + 1))){
                occurs.add(s.charAt(rp+1));
                ++rp;
            }
            ans = Math.max(ans, rp - i + 1);
        }
        return ans;
    }
}

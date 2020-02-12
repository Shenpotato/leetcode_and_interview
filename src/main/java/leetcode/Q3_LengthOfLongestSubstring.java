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


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

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
        if(slength == 1){
            return 1;
        }
        for (int i = slength; i > 0; i--) {
            int j = slength - i;
            for (int m = 0; m < j; m++) {
                String substring = s.substring(m,m+i);
                if(findreplicate(substring)){
                    return i;
                }
            }

        }
        return 0;
    }

}

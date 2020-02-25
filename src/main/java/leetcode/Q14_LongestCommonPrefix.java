package leetcode;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:
所有输入只包含小写字母 a-z 。
*/

// 简单难度。多次通过。问题出现在string.substring(startindex, endindex)返回的是从startindex - endindex - 1 的字符串
public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int minlength = strs[0].length();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (minlength > strs[i].length()){
                minlength = strs[i].length();
                index = i;
            }
        }
        int flag = -1;
        for (int i = 0; i < minlength; i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i)) flag = 1;
            }
            if(flag == 1){
                return strs[0].substring(0,i);
            }
        }
        return strs[index];
    }
}

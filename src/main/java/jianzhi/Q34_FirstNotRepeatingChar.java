package jianzhi;

import java.util.ArrayList;

/*
 * 第一个只出现一次的字符
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * */
public class Q34_FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        ArrayList<Character> abandon = new ArrayList<>();
        for (int i = 0; i < str.length()-1; i++) {
            char temp = str.charAt(i);
            if(abandon.contains(temp)) continue;
            int index = str.substring(i+1).indexOf(temp);
            if(index == -1) return i;                       //若在后续子字符串中找不到该字符，则唯一
            else
                abandon.add(temp);
        }
        return -1;
    }
}

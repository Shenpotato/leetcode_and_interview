package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
        L   C   I   R
        E T O E S I I G
        E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
*/

// 核心思路：
// 1. 使用类似于动态的数组按行存储数据
// 2. 设置表示
public class Q6_Convert {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++)
            rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1)
                flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows)
            res.append(row);
        return res.toString();
    }


    public static void main(String[] args) {
        Q6_Convert q6_convert = new Q6_Convert();
        System.out.println(q6_convert.convert("LEETCODEISHIRING", 3));
    }
}

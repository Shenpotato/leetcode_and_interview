package jianzhi;

import java.util.ArrayList;

/*
 * 字符串的排列
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * */
public class Q27_Permutation {
    ArrayList<String> list = new ArrayList<>();

    // f(abc) = a * f(bc) + b * f(ac) + c * f(ab)
    // f(bc) = b * f(c)
    // f(c) = 1
    public ArrayList<String> permutation(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        ArrayList<String> result = permutationHelper(stringBuilder);
        return result;
    }

    public ArrayList<String> permutationHelper(StringBuilder stringBuilder) {
        ArrayList<String> result = new ArrayList<>();
        if (stringBuilder.length() == 1) result.add(stringBuilder.toString());
        else {
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (i == 0 || stringBuilder.charAt(i) != stringBuilder.charAt(0)){
                    char temp = stringBuilder.charAt(i);
                    stringBuilder.setCharAt(i, stringBuilder.charAt(0));
                    stringBuilder.setCharAt(0, temp);
                    ArrayList<String> newResult = permutationHelper(new StringBuilder(stringBuilder.substring(1)));
                    for (int j = 0; j < newResult.size(); j++) {
                        result.add(stringBuilder.substring(0,1)+newResult.get(j));
                    }
                    temp = stringBuilder.charAt(0);
                    stringBuilder.setCharAt(0, stringBuilder.charAt(i));
                    stringBuilder.setCharAt(i, temp);
                }
            }
        }
        return result;
    }
}

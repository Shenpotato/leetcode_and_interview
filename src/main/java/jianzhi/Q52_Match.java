package jianzhi;

/*
 * 正则表达式匹配
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * */
public class Q52_Match {
    public boolean match(char[] str, char[] pattern) {
        return isMatch(str.toString(), pattern.toString());
    }

    //    public boolean match(String str, String pattern) {
//        if (pattern.isEmpty()) return str.isEmpty();
//        boolean firstMatch = !str.isEmpty() && (pattern.charAt(0) == str.charAt(0) || pattern.charAt(0) == '.');
//        System.out.println(firstMatch);
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
//            return match(str, pattern.substring(2)) ||
//                    (firstMatch && match(str.substring(1), pattern));
//        }else
//            return firstMatch && match(str.substring(1), pattern.substring(1));
//    }
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //如果模式串中有星号，它会出现在第二个位置，即pattern[1] 。
        //这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即pattern[0] 。
        //如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }

}

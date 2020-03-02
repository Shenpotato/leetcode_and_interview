package jianzhi;

/*
 * 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * */
public class Q53_IsNumeric {
    public boolean isNumeric(char[] str) {
        int dotflag = -1, eflag = -1;
        for (int i = 0; i < str.length; i++) {
            if (Character.isDigit(str[i])) continue;
            if (str[i] == '.') {
                if (eflag != -1) return false;
                else if (dotflag != -1) return false;
                else dotflag = 1;
            } else {
                if (i == 0 && (str[0] == '+' || str[0] == '-')) continue;
                if (eflag == -1 && (str[i] == 'e' || str[i] == 'E')) {
                    eflag = 1;
                    if (i + 1 == str.length) return false;
                    if (i + 1 < str.length && (Character.isDigit(str[i + 1]) || str[i + 1] == '+' || str[i + 1] == '-')) {
                        i++;
                        continue;
                    }
                } else
                    return false;
            }
        }
        return true;
    }
}

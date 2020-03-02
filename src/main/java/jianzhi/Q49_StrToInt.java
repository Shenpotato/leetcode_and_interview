package jianzhi;

/*
 * 把字符串转换成整数
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 输入：+2147483647
 * 输出：2147483647
 * 输入：1a33
 * 输出：0
 * */
public class Q49_StrToInt {
    // 判断为空 - > 判断正负 - > 判断每个字符是否为数字 - > 进转换
    public int strToInt(String str) {
        if (str.length() == 0 || str.equals("")
                || str.charAt(0) == '+' && str.length() == 1 || str.charAt(0) == '-' && str.length() == 1  ) return 0;
        boolean isNeg = false;
        if (str.charAt(0) == '-') {
            isNeg = true;
            str = str.substring(1);
        }
        if (str.charAt(0) == '+') str = str.substring(1);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) return 0;
        }
        if(chars.length == 0) return 0;
        int temp = Integer.parseInt(String.valueOf(chars[0]));
        if (isNeg) {
            for (int i = 1; i < chars.length; i++) {
                if (temp > Integer.MAX_VALUE / 10 ||
                        temp == Integer.MAX_VALUE / 10 && Integer.parseInt(String.valueOf(chars[i])) > Integer.MAX_VALUE % 10 + 1)
                    return 0;
                temp = temp * 10 + Integer.parseInt(String.valueOf(chars[i]));
            }
            temp = -temp;
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (temp > Integer.MAX_VALUE / 10 ||
                        temp == Integer.MAX_VALUE / 10 && Integer.parseInt(String.valueOf(chars[i])) > Integer.MAX_VALUE % 10) {
                    return 0;
                } else {
                    temp = temp * 10 + Integer.parseInt(String.valueOf(chars[i]));
                }
            }
        }
        return temp;
    }

    // 正则表达式匹配
    public int StrToInt(String str) {
        // \d代表[0-9] 但是要写成\\d才行。
        if(!str.matches("[1-9,+,-]\\d+")) return 0;
        int len = str.length();
        int i = len-1;
        long res = 0;  //long类型，避免溢出。不能用int

        while(i>=0&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            res += Math.pow(10,len-1-i)*(str.charAt(i)-'0');
            i--;
        }
        res = (str.charAt(0) == '-' ? -res : res);
        //溢出就返回0，用long类型的res来比较，
        //如果定义为int res,那再比较就没有意义了，int范围为[-2147483648,2147483647]
        if(res>Integer.MAX_VALUE|| res<Integer.MIN_VALUE)return 0;
        return (int)res;
    }

}

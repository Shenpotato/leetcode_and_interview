package jianzhi;

/*
 * 求 1 + 2 + 3 + ... + n
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */
public class Q47_Sum {
    // 不用循环 - > 递归，不用判断 -> 短路求值
    public int sum(int n) {
        int result = n;
        // 当result > 0 不成立时，&& 右边不执行；若为 & 时，右边照常执行
        boolean flag = (result > 0) && ((result += sum(n - 1)) > 0);
        return result;
    }
}

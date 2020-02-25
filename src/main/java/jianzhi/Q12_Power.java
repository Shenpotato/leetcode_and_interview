package jianzhi;

/*
* 数值的整数次方
*
* 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
* 保证base和exponent不同时为0
* */
public class Q12_Power {
    // 区分 exponent > 0 or < 0
    public double power(double base, int exponent){
        double result = 1.0;
        if(exponent >= 0){
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
        }else{
            for (int i = 0; i < Math.abs(exponent); i++) {
                result = result * (1/base);
            }
        }
        return result;
    }
}

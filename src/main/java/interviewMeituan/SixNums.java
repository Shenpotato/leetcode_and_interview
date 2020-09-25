package interviewMeituan;

import java.util.Scanner;

/*
* 小团想要编写一个程序，希望可以统计在M和N之间（M<N，且包含M和N）有多少个六位数ABCDEF满足以下要求：

(1) ABCDEF这六个数字均不相同，即A、B、C、D、E和F表示六个不同的数字。

(2) AB+CD=EF。即将这个六位数拆成三个两位数，使得第1个和第2个两位数的和等于第3个两位数。

（注意：AB、CD和EF都必须是正常的两位数，因此A、C和E都不能等于0。）



输入描述
单组输入。

输入两个六位正整数M和N（M<N），两者之间用空格隔开。

输出描述
输出在M到N之间（包含M和N）满足要求的六位数的个数。


样例输入
100000 110000
样例输出
0
**/
public class SixNums {

    public void findNums() {
        Scanner scanner = new Scanner(System.in);
        int lowIndex = scanner.nextInt();
        int highIndex = scanner.nextInt();
        int count = 0;
        for (int i = lowIndex; i <= highIndex; i++) {
            char chars[] = Integer.toString(i).toCharArray();
            if (constraint(chars)) {
                int AB = (Character.valueOf(chars[0]) - 48) * 10 + Character.valueOf(chars[1]) - 48;
                int CD = (Character.valueOf(chars[2]) - 48) * 10 + Character.valueOf(chars[3]) - 48;
                int EF = (Character.valueOf(chars[4]) - 48) * 10 + Character.valueOf(chars[5]) - 48;
                if (AB + CD == EF) {
                    count++;
                }
            } else {
                continue;
            }

        }
        System.out.println(count);
    }

    public boolean constraint(char[] chars) {
        if (chars[0] != chars[1] && chars[0] != chars[2] && chars[0] != chars[3] && chars[0] != chars[4] && chars[0] != chars[5]
                && chars[1] != chars[2] && chars[1] != chars[3] && chars[1] != chars[4] && chars[1] != chars[5]
                && chars[2] != chars[3] && chars[2] != chars[4] && chars[2] != chars[5]
                && chars[3] != chars[4] && chars[4] != chars[5] && chars[3] != chars[5]
        ) {
            if (chars[0] != '0' && chars[2] != '0' && chars[4] != '0') {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SixNums sixNums = new SixNums();
        sixNums.findNums();
    }
}

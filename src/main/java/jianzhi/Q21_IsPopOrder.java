package jianzhi;

import java.util.Stack;

/*
 * 栈的压入弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * */
public class Q21_IsPopOrder {
    // 思路：
    // 判断出栈是否合理，则就构造个栈，来实现入栈和出栈。
    // 根据pushA顺序入栈，当遇到与popA相同时就出战出栈，判断栈最后为不为空，即可证明是不是为正确的出栈顺序
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

}

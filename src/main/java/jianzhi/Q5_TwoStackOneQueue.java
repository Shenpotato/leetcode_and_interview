package jianzhi;

import java.util.Stack;
/*
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * */
public class Q5_TwoStackOneQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    /*
    * use the stack2 as pop stack,
    * when stack2 is empty, statck2 push stack1.pop
    * */
    public int pop() {
        if(!stack2.isEmpty())
            return stack2.pop();
        else{
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }
}

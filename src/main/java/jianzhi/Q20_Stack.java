package jianzhi;


import java.util.Stack;

/*
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * */

// 这种方法只借助一个栈和一个minElement，但是会引起栈长度的变化
public class Q20_Stack {

//    // 这种方法只借助一个栈和一个minElement，但是会引起栈长度的变化
//    private Stack<Integer> stack = new Stack();
//    private Integer minElemnt = Integer.MAX_VALUE;
//
//    public void push(int node) {
//        if(stack.isEmpty()){
//            stack.push(node);
//            minElemnt = node;
//        }else{
//            if(minElemnt > node) {
//                stack.push(minElemnt);          // 更新最小值前保留先前的最小值
//                minElemnt = node;
//            }
//            stack.push(node);
//        }
//    }
//
//    public void pop() {
//        if(stack.size()==0) return;
//        if(minElemnt == stack.peek()){
//            if(stack.size() > 1){
//                stack.pop();                    // 多pop出一个保存在最小值下面的第二小值
//                minElemnt = stack.peek();
//            }else
//                minElemnt = Integer.MAX_VALUE;
//        }
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int min() {
//        return minElemnt;
//    }

    //辅助栈, 用于保存栈在每一个时刻的最小值
    Stack<Integer> stackTotal = new Stack<>();
    Stack<Integer> stackLittle = new Stack<>();

    public void push(int node) {
        stackTotal.push(node);
        if(stackLittle.empty()) {
            stackLittle.push(node);
        }else {
            if (stackLittle.peek() > node)
                stackLittle.push(node);
            else stackLittle.push(stackLittle.peek());
        }
    }

    public void pop() {
        stackTotal.pop();
        stackLittle.pop();

    }

    public int top() {
        return stackTotal.peek();
    }

    public int min() {
        return stackLittle.peek();
    }

}

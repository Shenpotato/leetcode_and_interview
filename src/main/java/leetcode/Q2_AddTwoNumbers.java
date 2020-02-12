package leetcode;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
//
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//        示例：
//
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807


import com.sun.tools.classfile.ConstantPool;

import java.util.List;

public class Q2_AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode currentnode = result;
        int num1 = 0;
        int num2 = 0;
        int count1 = 1;
        int count2 = 1;
        while(l1 != null){
            int time1 = 1;
            for(int i = 0;i<count1-1;i++){
                time1 = time1 * 10;
            }
            num1 = num1 + l1.val*time1;
            count1 ++;
            l1 = l1.next;
        }
        while(l2 !=null){
            int time2 = 1;
            for(int i = 0;i<count2-1;i++){
                time2 = time2 * 10;
            }
            num2 = num2 + l2.val*time2;
            count2 ++;
            l2 = l2.next;
        }

        System.out.println(num2);
        int sum = num1 + num2;
        char[] arrays = String.valueOf(sum).toCharArray();
        System.out.println(arrays);
        for(int i=arrays.length-1;i>=0;i--){
            currentnode.val = Character.getNumericValue(arrays[i]);
            if(i==0){
                currentnode.next = null;
                break;
            }
            currentnode.next = new ListNode(0);
            currentnode = currentnode.next;
        }
        return result;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        Q2_AddTwoNumbers q2_addTwoNumbers = new Q2_AddTwoNumbers();
        q2_addTwoNumbers.addTwoNumbers(l1,l2);
    }

}

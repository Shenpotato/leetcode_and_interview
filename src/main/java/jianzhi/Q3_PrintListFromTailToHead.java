package jianzhi;

import java.util.ArrayList;


/*
 * 从尾到头打印一个链表
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * */
public class Q3_PrintListFromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> listFromHeadToTail = new ArrayList<>();
        ArrayList<Integer> listFromTailToHead = new ArrayList<>();
        ListNode currentNode = listNode;
        while (currentNode != null) {
            listFromHeadToTail.add(currentNode.val);
            currentNode = currentNode.next;
        }
        // 翻转当前List
        for (int i = listFromHeadToTail.size()-1; i >= 0; i--) {
            listFromTailToHead.add(listFromHeadToTail.get(i));
        }
        return listFromTailToHead;
    }
}

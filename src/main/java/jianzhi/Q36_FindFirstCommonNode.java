package jianzhi;

import java.util.HashSet;

/*
 * 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * */
public class Q36_FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Solu1: 遍历第一个链表，保存链表到set里；遍历第二个链表，第一次出现相同ListNode即为第一个公共节点
    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (pHead1 != null) {
            listNodes.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (listNodes.contains(pHead2)) return pHead2;
            else pHead2 = pHead2.next;
        }
        return null;
    }

    // Solu2：别人的天才解法
    // list1: 0 1 2 3 4 5 null
    // list2: a b 4 5 null
    // 当把list1 和 list2 加起来,
    // newlist1: 0 1 2 3 4 5 a b 4 5
    // newlist2: a b 4 5 0 1 2 3 4 5
    // 最后相等的一定是第一个相同的公共节点
    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = pHead2;
                if (p2 == null) p2 = pHead1;
            }
        }
        return p1;
    }
}

package jianzhi;

import java.util.HashSet;

/*
 * 链表中环的入口节点
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * */
public class Q55_EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    // Solu1: 使用集合类保存
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode curNode = pHead;
        HashSet<ListNode> listNodes = new HashSet<>();
        while(curNode != null){
            if(listNodes.contains(curNode)) return curNode;
            else{
                listNodes.add(curNode);
                curNode = curNode.next;
            }
        }
        return null;
    }

    // Solu2: 数学法
    // 假设两个指针，快指针的速度是慢指针的两倍，环前举例是a, 相遇位置离环入口位置距离b和c。
    // 存在等式 2(a + b) = a + b + c + b --> a = c
    // 再定一个慢指针2速度与原先慢指针1相同，慢指针2和慢指针1相遇的地方就是环入口位置
    public ListNode entryNodeOfLoop2(ListNode pHead){
        if(pHead == null || pHead.next == null) return null;
        ListNode fastNode = pHead, slowNode1 = pHead, slowNode2 = pHead;
        while(slowNode1 != null && slowNode1.next!=null){
            slowNode1 = slowNode1.next;
            fastNode = fastNode.next.next;
            if(fastNode == slowNode1){
                while(slowNode1 != slowNode2){
                    slowNode1 = slowNode1.next;
                    slowNode2 = slowNode2.next;
                }
            }
        }
        return slowNode1;
    }
}

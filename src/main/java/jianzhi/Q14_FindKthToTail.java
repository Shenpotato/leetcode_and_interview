package jianzhi;

/*
 * 链表中倒数第 k 个节点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 * */
public class Q14_FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 先遍历获得链表长度，计算出正序的节点, 注意链表为空和k值为空，k值超过链表长度的判断
    public ListNode findKthToTail1(ListNode head, int k) {
        if(head == null || k <= 0) return null;
        ListNode currentNode = head;
        int length = 0;                         // 链表长度
        while (currentNode != null) {
            currentNode = currentNode.next;
            length++;
        }
        int place = length - k;
        if (place < 0) return null;
        if (place == 0) return head;
        else {
            currentNode = head;
            while(place > 0) {
                currentNode = currentNode.next;
                place--;
            }
        }
        return currentNode;
    }

    // 使用快慢指针，快指针先走k步，快指针到结尾时，慢指针的位置是倒数第k个节点
    public ListNode findKthToTail2(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode slowNode = head;
        ListNode fastNode = head;
        for (int i = 0; i < k; i++) {
            if (fastNode == null) return null;
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

}

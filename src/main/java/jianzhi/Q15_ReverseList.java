package jianzhi;

/*
 * 链表反转
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 * */
public class Q15_ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;                    //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode p = null;                          //初始化p指针，用于记录当前结点的下一个结点地址
        while (head != null) {                        //head指向null时，循环终止。
            p = head.next;                          //先用p指针记录当前结点的下一个结点地址。
            head.next = preNode;                    //让被当前结点与链表断开并指向前一个结点pre。
            preNode = head;                         //pre指针指向当前结点
            head = p;                               //head指向p(保存着原链表中head的下一个结点地址)
        }
        return preNode;                             //当循环结束时,pre所指的就是反转链表的头结点
    }
}

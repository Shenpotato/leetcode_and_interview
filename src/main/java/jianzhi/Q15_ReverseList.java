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
        ListNode nextNode = null;                   //初始化nextNode指针，用于记录当前结点的下一个结点地址
        ListNode curNode = head;                    //初始化curNode指针，用于记录当前节点
        while (curNode != null) {                   //curNode指向null时，循环终止。
            nextNode = curNode.next;                //先用nextNode指针记录当前结点的下一个结点地址。
            curNode.next = preNode;                 //让被当前结点与链表断开并指向前一个结点pre。
            preNode = curNode;                      //pre指针指向当前结点
            curNode = nextNode;                     //curNode指向nextNode(保存着原链表中head的下一个结点地址)
        }
        return preNode;                             //当循环结束时,pre所指的就是反转链表的头结点
    }

}

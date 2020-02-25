package jianzhi;

/*
* 合并两个排序链表
*
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * */
public class Q16_Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode headNode = new ListNode(-1);
        ListNode currentNode = headNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            }else{
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }
        if(list1 != null) currentNode.next = list1;
        if(list2 != null) currentNode.next = list2;
        return headNode.next;
    }
}

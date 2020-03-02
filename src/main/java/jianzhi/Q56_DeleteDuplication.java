package jianzhi;

/*
 * 删除链表中重复的节点
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * */
public class Q56_DeleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null) return pHead;
        ListNode headNode = new ListNode(Integer.MAX_VALUE);        // 辅助头节点
        headNode.next = pHead;
        ListNode curNode = headNode.next, preNode = headNode, nextNode;
        while(curNode != null){
            nextNode = curNode.next;
            // 当遇到相同的元素时，包括多个相同元素
            if(nextNode != null && nextNode.val == curNode.val){
                while(nextNode != null && nextNode.val == curNode.val){
                    nextNode = nextNode.next;
                }
                preNode.next = nextNode;
                curNode = nextNode;
            }else{
                preNode = curNode;
                curNode = nextNode;
            }
        }
        return headNode.next;
    }
}

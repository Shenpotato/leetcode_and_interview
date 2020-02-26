package jianzhi;

import java.util.HashMap;
import java.util.Map;

/*
 * 复杂链表的复制
 *
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */
public class Q25_Clone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode newHead = null;
        RandomListNode p = pHead;               // 遍历旧链表的指针
        RandomListNode q = null;                // 遍历新链表的指针
        Map<RandomListNode, RandomListNode> randomNodeMap = new HashMap<>();
        while (p != null) {
            if (newHead == null) {
                newHead = new RandomListNode(pHead.label);
                q = newHead;
                randomNodeMap.put(pHead, newHead);
            } else {
                if (p.next != null && randomNodeMap.containsKey(p.next))
                    q.next = randomNodeMap.get(p.next);
                else {
                    if (p.next != null) {
                        RandomListNode temp = new RandomListNode(p.next.label);
                        randomNodeMap.put(p.next, temp);
                        q.next = temp;
                    }
                }
                if (p.random != null && randomNodeMap.containsKey(p.random))
                    q.random = randomNodeMap.get(p.random);
                else {
                    if (p.random != null) {
                        RandomListNode temp = new RandomListNode(p.random.label);
                        randomNodeMap.put(p.random, temp);
                        q.random = temp;
                    }
                }
                p = p.next;
                q = q.next;
            }
        }
        return newHead;
    }
}

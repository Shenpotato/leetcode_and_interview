package interviewTencent;

import java.util.Scanner;

public class Q1_FindCommon {
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public void findCommon() {
        // get input
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        Node pre1 = new Node(scanner.nextInt());
        Node head1 = pre1;
        for (int i = 0; i < len1 - 1; i++) {
            Node cur1 = new Node(scanner.nextInt());
            pre1.next = cur1;
            pre1 = cur1;
        }

        int len2 = scanner.nextInt();
        Node pre2 = new Node(scanner.nextInt());
        Node head2 = pre2;
        for (int i = 0; i < len2 - 1; i++) {
            Node cur2 = new Node(scanner.nextInt());
            pre2.next = cur2;
            pre2 = cur2;
        }

        // make new list to store common part
        Node commonPre = new Node(0);
        Node commonHead = commonPre;
        Node commonCur = commonHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head2 = head2.next;
            } else if (head1.val > head2.val) {
                head1 = head1.next;
            } else {
                commonCur = new Node(head1.val);
                commonPre.next = commonCur;
                commonPre = commonCur;
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        // output the common list
        Node outputHead = commonHead.next;
        while (outputHead != null) {
            System.out.print(outputHead.val);
            System.out.print(" ");
            outputHead = outputHead.next;
        }
    }


    public static void main(String[] args) {
        Q1_FindCommon q1_findCommon = new Q1_FindCommon();
        q1_findCommon.findCommon();
    }
}

package LinkedList.PartitionList_86;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(0), p2 = new ListNode(0);
        ListNode newHead = p1, divide = p2;
        while (head != null){
            if (head.val < x){
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = divide.next;
        return newHead.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}

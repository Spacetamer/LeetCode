package LinkedList.RemoveDuplicatesFromSortedList_83;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(Integer.MAX_VALUE), newHead = p;
        while(head != null){
            if (head.val != p.val) {
                p.next = head;
                p = head;
            }
            head = head.next;
        }
        p.next = null;
        return newHead.next;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}

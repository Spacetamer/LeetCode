package LinkedList.RemoveValueInLinkedList_203;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head!= null && head.val==val) head = head.next;
        ListNode last = null;
        ListNode current = head;
        while (current != null){
            if (current.val == val) last.next = current.next;
            else last = current;
            current = current.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
package LinkedList.PalindromeList_234;

class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode p1 = head, p2 = head;
        try{
            while(true){
                p2 = p2.next.next;
                p1 = p1.next;
            }
        }catch(NullPointerException e){}

        ListNode newHead = null;
        while (p1 != null) {
            ListNode next = p1.next;
            p1.next = newHead;
            newHead = p1;
            p1 = next;
        }

        p1 = newHead; p2 = head;
        try{
            while(true){
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }
        }catch(NullPointerException e){}

        return true;
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

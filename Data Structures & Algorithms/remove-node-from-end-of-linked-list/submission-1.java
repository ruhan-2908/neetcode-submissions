/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);
        if(length == n) return head.next;
        ListNode slow = head;
        ListNode fast = head;
        while(n > 0)
        {
            fast = fast.next;
            n--;
        }
        ListNode prev = null;
        while(fast!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        } 
        prev.next = slow.next;
        return head;
    }
    public int findLength(ListNode head)
    {
        int n = 0;
        while(head!= null)
        {
            head =head.next;
            n++;
        }
        return n;
    }
}

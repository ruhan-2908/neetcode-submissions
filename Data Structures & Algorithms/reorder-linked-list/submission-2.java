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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        l2 = reverse(l2);
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        while(l1!=null && l2!=null)
        {
            l1.next = l2;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
            if(n1!=null) n1 = n1.next;
            if(n2!=null) n2 = n2.next;
        }
        if(l2!=null)
        {
            l1.next = l2;
        }
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

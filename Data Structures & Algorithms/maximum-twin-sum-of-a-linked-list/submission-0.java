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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = reverse(slow);

        int sum = 0 ;

        while(head != null || head2!= null)
        {
            int val1 = head != null ? head.val : 0;
            int val2 = head2 != null ? head2.val : 0;
            sum = Integer.max(sum, val1 + val2);
            if(head!=null) head = head.next;
            if(head2!=null) head2 = head2.next;
        }
        return sum;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current!=null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
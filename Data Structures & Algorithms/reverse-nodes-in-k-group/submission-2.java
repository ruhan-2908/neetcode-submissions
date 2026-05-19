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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1,head);
        ListNode groupPrev = dummy;
        while(true)
        {
            ListNode kth = findKthNode(groupPrev,k);
            if(kth == null) break;

            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while(curr != groupNext)
            {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode tempo = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = tempo;
        }
        return dummy.next;
    }
    public ListNode findKthNode(ListNode head, int k)
    {
        while(head!= null && k > 0)
        {
            head = head.next;
            k--;
        }
        return head;
    }
}

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
            ListNode kth = findKth(k,groupPrev);
            if(kth == null) break;

            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            ListNode groupNext = kth.next;

            while(curr!=groupNext)
            {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            ListNode tempo = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = tempo;
        }
        return dummy.next;
    }
    public ListNode findKth(int k , ListNode head)
    {
        while(k > 0 && head!=null)
        {
            head = head.next;
            k--;
        }
        return head;
    }
}

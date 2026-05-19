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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
        ListNode base = lists[0];
        for(int i=1;i<lists.length ; i++)
        {
            base = mergeThem(base,lists[i]);
        }
        return base;
    }
    public ListNode mergeThem(ListNode head1, ListNode head2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head1!=null && head2!=null)
        {
            if(head1.val < head2.val)
            {
                temp.next = head1;
                head1 = head1.next;
            }
            else
            {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1!=null) temp.next = head1;
        else temp.next = head2;
        return dummy.next;
    }
}

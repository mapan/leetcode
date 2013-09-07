/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,cur=head,next=head;
        int i=0;
        while(i++!=n) next=next.next;
        while(next!=null) {
            pre=cur;
            cur=cur.next;
            next=next.next;
        }
        pre.next=cur.next;
        cur.next=null;
        return dummy.next;
    }
}

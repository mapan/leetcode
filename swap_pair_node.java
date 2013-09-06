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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        ListNode p=null,pre=head,cur=head.next,next=cur.next;
        int ind=1;
        while(cur!=null) {
            if(ind%2!=0) {
                cur.next=pre;
                pre.next=next;
                if(p!=null) p.next=cur;
                if(ind==1) head=cur;
            }
            else {
                p=pre;
                pre=cur;
            }
            ind++;
            cur=next;
            if(next!=null) next=next.next;
        }
        return head;
    }
}

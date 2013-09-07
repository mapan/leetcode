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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        int len=0;
        ListNode h=head,pre=null,curr=head,p;
        while(h!=null) {
            len++;
            h=h.next;
        }
        int k=n%len,i=1;
        if(k==0) return head;
        while(i<len-k+1) {
            pre=curr;
            curr=curr.next;
            i++;
        }
        pre.next=null;
        p=curr;
        while(curr.next!=null) curr=curr.next;
        curr.next=head;
        head=p;
        return head;
    }
}

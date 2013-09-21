
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode d=new ListNode(0);
        d.next=head;
        int i=0;
        ListNode n1=head,n2=head;
        if(n1==null||n1.next==null) return head;
        //n%=len;
        while(i++<n) {
            n2=n2.next;
            if(n2==null) n2=head;
        }
        while(n2.next!=null) {
            n1=n1.next;
            n2=n2.next;
        }
        n2.next=d.next;
        d.next=n1.next;
        n1.next=null;
        return d.next;
    }
}


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

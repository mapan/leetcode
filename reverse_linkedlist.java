ListNode previous=null;
    public ListNode reverse(ListNode p) {
        if(p==null) return null;
        ListNode next=p.next;
        if(previous==null) 
            p.next=null;
        else 
            p.next=previous;
        previous=p;
        reverse(next);
        return p;
    }
previous will be the new head
http://leetcode.com/2010/04/reversing-linked-list-iteratively-and.html


public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m==n) return head;
        ListNode previous=null,curr=head,next=curr.next,left=null;
        int i=1;
        while(i!=m) {   //i++!=m
            previous=curr;
            curr=next;
            curr=curr.next;
            i++;
        }
        left=previous;
        next=curr.next;
        previous=curr;
        curr=next;
        next=next.next;
        i++;
        while(i!=n+1) {
            curr.next=previous;
            previous=curr;
            curr=next;
            if(next!=null)
                next=next.next;
            i++;
        }
        if(left==null) {
            head.next=curr;
            return previous;
        }
        else {
            left.next.next=curr;
            left.next=previous;
            return head;
        }
    }
}

http://discuss.leetcode.com/questions/206/reverse-nodes-in-k-group

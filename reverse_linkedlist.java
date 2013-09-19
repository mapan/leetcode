public class Solution {
    ListNode h;
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        h=null;
        int i=1;
        ListNode d=new ListNode(1);
        d.next=head;
        ListNode pre=d,cur=head;
        // find the head
        while(i!=m&&cur!=null) {
            pre=cur;
            cur=cur.next;
            i++;
        }
        int j=i;
        ListNode next=cur,p=null;
        // find the tail
        while(j!=n&&next!=null) {
            next=next.next;
            j++;
        }
        p=next;
        next=next.next;
        p.next=null; // make the tail null then call reverse
        reverse(cur,null);
        pre.next=h;
        cur.next=next;
        return d.next;
    }
    public void reverse(ListNode node,ListNode pre) {
        if(node==null) return;
        reverse(node.next,node);
        node.next=pre;
        if(h==null) h=node;
    }
}


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
    ListNode h;
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null) return null;
        ListNode d=new ListNode(0);
        d.next=head;
        ListNode pre=d,s=head,e=head,next;
        int i=1;
        while(true) {
            while(e!=null&&i<k) {
                i++;
                e=e.next;
            }
            if(e==null) return d.next;
            next=e.next;
            e.next=null;
            reverse(s,next);
            pre.next=e;
            pre=s;
            s=s.next;
            e=s;
            i=1;
        }
        //return d.next;
    }
    public void reverse(ListNode node,ListNode pre) {
        if(node==null) return;
        reverse(node.next,node);
        node.next=pre;
    }
}


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

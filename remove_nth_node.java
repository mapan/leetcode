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

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        r(head,dummy,n);
        return dummy.next;
    }
    public int r(ListNode node,ListNode pre,int n) {
        if(node==null) return 0;
        int pos=r(node.next,node,n)+1;
        if(pos==n) {
            pre.next=node.next;
            node.next=null;
        }
        return pos;
    }
}

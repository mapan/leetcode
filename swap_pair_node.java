
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        ListNode d=new ListNode(1);
        d.next=head;
        ListNode pre=d,cur=head,next=head.next;
        while(cur!=null&&cur.next!=null) {
            cur.next=next.next;
            next.next=cur;
            pre.next=next;
            pre=cur;
            cur=cur.next;
            if(cur!=null) next=cur.next;
        }
        return d.next;
    }
}

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


while(cur!=null) {
            while(cur!=null&&cur.val==pre.val) {
                cur=cur.next;
            }
            if(cur==null) {
                pre.next=null;
                return head;
            }
            else {
                pre.next=cur;
                pre=cur;
                cur=cur.next;
            }
        }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        ListNode pre=head,cur=head.next;
        while(cur!=null) {
            if(cur.val==pre.val) {
                pre.next=cur.next;
                cur.next=null;
                cur=pre.next;
            }
            else {
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,cur=head,next=head.next;
        while(next!=null) {
            if(next.val==cur.val) {
                while(next!=null&&next.val==cur.val) {
                    next=next.next;
                }
                if(next==null) {
                    pre.next=null;
                    return d.next;
                }
                pre.next=next;
                cur=next;
                next=next.next;
            }
            else {
                pre=cur;
                cur=next;
                next=next.next;
            }
        }
        return dummy.next;
    }
}
        while(next!=null) {
            if(next.val==cur.val) {
                while(next!=null&&next.val==cur.val) {
                    next=next.next;
                }
                pre.next=next;
                cur=next;
                if(next!=null) next=next.next;
            }
            else {
                pre=cur;
                cur=next;
                next=next.next;
            }
        }

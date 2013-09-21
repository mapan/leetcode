public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode d=new ListNode(0);
        ListNode p=d;
        while(l1!=null&&l2!=null) {
            if(l1.val<l2.val) {
                p.next=l1;
                l1=l1.next;
            }
            else {
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        p.next=(l1!=null?l1:l2);
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode n=new ListNode(0);
        merge(l1,l2,n);
        return n.next;
    }
    public void merge(ListNode l1,ListNode l2,ListNode cur) {
        if(l1==null||l2==null) {
            if(l1!=null) cur.next=l1;
            if(l2!=null) cur.next=l2;
            return;
        }
        if(l1.val<l2.val) {
            cur.next=l1;
            merge(l1.next,l2,l1);
        }
        else {
            cur.next=l2;
            merge(l1,l2.next,l2);
        }
    }
}

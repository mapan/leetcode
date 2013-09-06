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
    ListNode head,p;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        head=p=null; //!!!!!!!!!!!
        add(l1,l2,0);
        return head;
    }
    public void add(ListNode l1,ListNode l2,int carry) {
        if(l1==null&&l2==null) {
            if(carry==1) {
                p.next=new ListNode(1);
            }
            return;
        }
        if(l1==null) {
            while(l2!=null) {
                int b=l2.val;
                int r=b+carry;
                carry=r>=10?1:0;
                ListNode n=new ListNode(r%10);        
                p.next=n;
                p=n;
                l2=l2.next;
            }
            if(carry==1) {
                p.next=new ListNode(1);
            }
            return;
        }
        if(l2==null) {
            while(l1!=null) {
                int b=l1.val;
                int r=b+carry;
                carry=r>=10?1:0;
                ListNode n=new ListNode(r%10);        
                p.next=n;
                p=n;
                l1=l1.next;
            }
            if(carry==1) {
                p.next=new ListNode(1);
            }
            return;
        }
        int a=l1.val;
        int b=l2.val;
        int r=a+b+carry;
        carry=r>=10?1:0;
        ListNode n=new ListNode(r%10);
        if(head==null) head=p=n;
        /*if(head==null) {
            head=new ListNode(r%10);
            p=head;
        }*/
        else {
            p.next=new ListNode(r%10);
            p=p.next;
        }
        add(l1.next,l2.next,carry);
    }
}

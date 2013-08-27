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

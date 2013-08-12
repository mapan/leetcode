/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length==0) return null;
        return buildBST(num,0,num.length-1);
    }
    public TreeNode buildBST(int[]num,int start,int end) {
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(num[mid]);
        root.left=buildBST(num,start,mid-1);
        root.right=buildBST(num,mid+1,end);
        return root;
    }
}

public class Solution {
    public static ListNode head2;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p=head;
        head2=head;
        int len=0;
        while(p!=null) {
            len++; p=p.next;
        }
        if(len==0) return null;
        //private static ListNode h=new ListNode(1);h=head;
        return buildBST(0,len-1);
    }
    public TreeNode buildBST(int start,int end) {
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(0);
        root.left=buildBST(start,mid-1);
        //TreeNode root=new TreeNode(head2.val);
        root.val=head2.val;
        head2=head2.next;
        root.right=buildBST(mid+1,end);
        return root;
    }
}
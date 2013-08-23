/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        c(root);
    }
    public TreeLinkNode c(TreeLinkNode root) {
        if(root==null||(root.left==null&&root.right==null)) 
            return root;
        TreeLinkNode l=c(root.left);
        TreeLinkNode r=c(root.right);
        l.next=r;
        while(l.right!=null) {
            l.right.next=r.left;
            l=l.right;
            r=r.left;
        }
        return root;
    }
}

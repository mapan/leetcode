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
        if(root==null) return;
        traverse(root);
    }
    public TreeLinkNode traverse(TreeLinkNode root) {
        if(root==null) return null;
        TreeLinkNode left,right;
        left=traverse(root.left);
        right=traverse(root.right);
        if(left!=null) {
            left.next=right;
            while(left.right!=null) {
                left.right.next=right.left;
                left=left.right;
                right=right.left;
            }
        }
        return root;
    }
}

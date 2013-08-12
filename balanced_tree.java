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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(traverse(root) == -10)
            return false;
        return true;
    }
    
    public int traverse(TreeNode root) {
        if(root == null) return -1;
        int left = traverse(root.left);
        int right = traverse(root.right);
        if(left-right>1 || right-left>1 || left==-10 || right==-10)
            return -10;
        int h = left>right ? left:right;
        return h+1;
    }
}
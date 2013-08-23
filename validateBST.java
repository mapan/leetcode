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
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
        boolean left,right;
        if(root.left==null||root.left.val<root.val)
            left = isValidBST(root.left);
        else 
            return false;
        if(!left) return false;
        if(root.right==null||root.right.val>root.val)
            right = isValidBST(root.right);
        else
            return false;
        return left&&right;
        return bst(root);
    }
    public boolean bst(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left!=null)
                if(node.left.val<node.val)
                    q.add(node.left);
                else return false;
            if(node.right!=null)
                if(node.right.val>node.val)
                    q.add(node.right);
                else return false;           
        }
        return true;
    }
}

public class Solution {
    int previous;
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        previous=Integer.MIN_VALUE;
        return b(root);
    }
    public boolean b(TreeNode root) {
        if(root==null) return true;
        if(!b(root.left))
            return false;
        if(root.val<=previous)
            return false;
        previous=root.val;
        return b(root.right);
    }
}

http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

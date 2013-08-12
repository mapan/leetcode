public class Solution {
    ArrayList<Integer> inorder;
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        inorder = new ArrayList<Integer>();
        in(root);
        return inorder;
    }
    public void in(TreeNode root) {
        if(root==null) return;
        in(root.left);
        inorder.add(root.val);
        in(root.right);
    }
}

https://sites.google.com/site/sarvasite/algorithms/trees/tree-traversal
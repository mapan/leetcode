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
    ArrayList<TreeNode> t;
    TreeNode previous;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        t = new ArrayList<TreeNode>();
        previous=null;
        inorder(root);
        int temp = t.get(0).val;
        t.get(0).val = t.get(t.size()-1).val;
        t.get(t.size()-1).val = temp;
        //被换的恰好在头和尾
    }
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(previous!=null&&previous.val>root.val) {
            if(!t.contains(previous)) t.add(previous); //no need contains
            if(!t.contains(root)) t.add(root);
        }
        previous = root;
        inorder(root.right);
    }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==q&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}

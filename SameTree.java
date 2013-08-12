public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val!=q.val) return false;
        boolean left=isSameTree(p.left,q.left);
        if(!left) return left;
        boolean right=isSameTree(p.right,q.right);
        return right;
    }
}
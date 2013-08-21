public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null) return q==null;
        if(q==null) return false;
        //if(p==null&&q==null) return true;
        //if(p==null||q==null) return false;
        return (p.val==q.val)&&(isSameTree(p.left,q.left))&&(isSameTree(p.right,q.right));
    }
}

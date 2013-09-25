public class Solution {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sum(root,0);
    }
    public int sum(TreeNode root,int s) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return s*10+root.val;
        return sum(root.left,s*10+root.val)+sum(root.right,s*10+root.val);
    }
}

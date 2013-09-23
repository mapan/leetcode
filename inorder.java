public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> r=new ArrayList<Integer>();
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode n=root;
        while(true) {
            while(n!=null) {
                s.push(n);
                n=n.left;
            }
            if(s.isEmpty()) return r;
            n=s.pop();
            r.add(n.val);
            n=n.right;
        }
    }
}

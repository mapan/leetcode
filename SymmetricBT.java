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
    List<Integer> value;
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return true;
        value = new ArrayList<Integer>();
        in(root);
        return p(value);
    }
    public void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        value.add(root.val);
        inorder(root.right);
    }
    public boolean palindrome(List<Integer> value) {
        if(value.size()<=1) return true;
        return value.get(0)==value.get(value.size()-1) && palindrome(value.subList(1,value.size()-1));
    }
    public boolean p(List<Integer> value) {
        int size = value.size();
        while(size>1) {
            if(value.get(0)!=value.get(size-1)) return false;
            value = value.subList(1,size-1);
            size = value.size();
        }        
        return true;
    }
    Stack<TreeNode> s;
    public void in(TreeNode root) {
        s = new Stack<TreeNode>();
        s.push(root);
        TreeNode x=root.left;
        while(x!=null||!s.isEmpty()) {
            if(x!=null) {
                // push the non-null x first
                s.push(x);
                x = x.left;
            }  
            else {
                x = s.pop();
                value.add(x.val);
                x = x.right;
            }
        }
    }
}
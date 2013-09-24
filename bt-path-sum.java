public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return false;
        if(root.left==null&&root.right==null) return sum==root.val;
        //if(hasPathSum(root.left,sum-root.val)) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}
public class Solution {
    ArrayList<ArrayList<Integer>> r;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        if(root==null) return r;
        path(root,sum,new ArrayList<Integer>());
        return r;
    }
    public void path(TreeNode root,int sum,ArrayList<Integer> sofar) {
        if(root==null) return;
        //sofar.add(root.val);
        if(root.left==null&&root.right==null) {
            if(root.val==sum) {
                ArrayList<Integer> cp=new ArrayList<Integer>(sofar);
                cp.add(root.val);
                r.add(cp);
                //return;
            }
            return;
        }
        sofar.add(root.val);
        path(root.left,sum-root.val,sofar);
        path(root.right,sum-root.val,sofar);
        sofar.remove(sofar.size()-1);
    }
}

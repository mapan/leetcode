public class Solution {
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return max(root,0);
    }
    public int max(TreeNode root,int depth) {
        if(root==null) {
            return depth;
        }
        int left=max(root.left,depth+1);
        int right=max(root.right,depth+1);
        return left>right?left:right;
    }
}

public int maxDepth() { 
  return(maxDepth(root)); 
}
private int maxDepth(Node node) { 
  if (node==null) { 
    return(0); 
  } 
  else { 
    int lDepth = maxDepth(node.left); 
    int rDepth = maxDepth(node.right);

    // use the larger + 1 
    return(Math.max(lDepth, rDepth) + 1); 
  } 
} 

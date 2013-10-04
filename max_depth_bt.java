public class Solution {
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int nodesNum = 1,level=0;
        while(!q.isEmpty()) {
            level++;
            int j = nodesNum; 
            nodesNum = 0;
            for(int i=0;i<j;i++) {
                TreeNode n = q.remove();
                if(n.left!=null) {
                    q.add(n.left);
                    nodesNum++;
                }
                if(n.right!=null) {
                    q.add(n.right);
                    nodesNum++;
                }
            }
        }
        return level;
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

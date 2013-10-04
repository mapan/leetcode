public class Solution {
    public int minDepth(TreeNode root) {
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
                if(n.left==null&&n.right==null) return level;
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

public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        return m(root);
    }
    public int m(TreeNode root) {
        if(root==null) {
            return Integer.MAX_VALUE;
        }
        if(root.left==null&&root.right==null) return 1;
        int left=m(root.left);
        int right=m(root.right);
        return Math.min(left,right)+1;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return min(root);
    }
    public int min(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left=min(root.left);
        int right=min(root.right);
        if(root.left==null) return right+1;   // a node has only one child
        if(root.right==null) return left+1;
        return Math.min(left,right)+1;  // has two
    }
}





public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    if (root.left == null && root.right == null)
        return 1;
    // Start typing your Java solution below
    // DO NOT write main() function
    return _minDepth(root, 1);
}

public int _minDepth(TreeNode root, int depth) {
    if (root == null)
        return depth - 1;

    int depthLeft = _minDepth(root.left, depth + 1);
    int depthRight = _minDepth(root.right, depth + 1);

    if (depthLeft == depth)
        return depthRight;
    if (depthRight == depth)
        return depthLeft;

    return depthLeft < depthRight ? depthLeft : depthRight;
}

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
    Queue<TreeNode> q; Queue<Integer> q2;
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0;
        q=new LinkedList<TreeNode>();
        q2=new LinkedList<Integer>();
        q.add(root);q2.add(1);
        while(!q.isEmpty()) {
            TreeNode n=q.poll();
            int level=q2.poll();
            if(n.left!=null) {
                q.add(n.left);q2.add(level+1);
            }
            if(n.right!=null) {
                q.add(n.right);q2.add(level+1);
            }
            if(n.left==null&&n.right==null) 
                return level;
        } 
        return 1;
    }
}

class Solution {
public:
   int maxPathSum(TreeNode *root) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int csum;
        int maxsum = INT_MIN;
        maxPathSumHelper(root, csum, maxsum);
        return maxsum;

    }
    void maxPathSumHelper(TreeNode *node, int &csum, int &maxsum) {
        if (!node) {
            csum = 0;
            return;
        }
        int lsum = 0, rsum = 0;
        maxPathSumHelper(node->left, lsum, maxsum);
        maxPathSumHelper(node->right, rsum, maxsum);
        csum = max(node->val, max(node->val + lsum, node->val + rsum));
        maxsum = max(maxsum, max(csum, node->val + lsum + rsum));
    }
};
One needs to handle three cases:

Left tree path plus the current root.
Right tree path plus the current root.
The path passes through the root and hence one needs to consider the left path + current root + right path.
In addition compare with the max path so far and update accordingly.

public static int maxPathSum(TreeNode root) {
    // pass the curmanx in an array that contains only one value
    ArrayList<Integer> curMax = new ArrayList<Integer>(1);
    curMax.add(Integer.MIN_VALUE);
    maxSubPath(root, curMax);
    return curMax.get(0);
}

private static int maxSubPath(TreeNode root, ArrayList<Integer> curMax) {
    if (root == null)  return 0;
    int leftMax = Math.max(0, maxSubPath(root.left, curMax));
    int rightMax = Math.max(0, maxSubPath(root.right, curMax));
    curMax.set(0, Math.max(curMax.get(0), root.val+leftMax+rightMax));
    return Math.max(root.val+leftMax, root.val+rightMax);

	int leftMax = maxSubPath(root.left, curMax);
	    int rightMax = maxSubPath(root.right, curMax);
	    int cur=Math.max(root.val,Math.max(root.val+leftMax, root.val+rightMax));
	    curMax.set(0, Math.max(cur,Math.max(curMax.get(0), root.val+leftMax+rightMax)));
	    //return Math.max(root.val+leftMax, root.val+rightMax);
	    return cur;
}

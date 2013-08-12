
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        build(root);
    }
    public TreeNode build(TreeNode root) {
        if(root==null) return null;
        TreeNode lefttail=build(root.left);
        TreeNode righttail=build(root.right);
        //if (left!=null) left.right = root.right;
        if (root.left!=null) {
            lefttail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (righttail!=null) return righttail;
        if (lefttail!=null) return lefttail;
        return root;
    }
}

public:
void flatten(TreeNode *root) {
    if (!root) return;

    TreeNode* left = root->left;
    TreeNode* right = root->right;

    if (left) {
        root->right = left;
        root->left = NULL;

        TreeNode* rightmost = left;
        while(rightmost->right) {rightmost = rightmost->right;}
        rightmost->right = right; // point the right most to the original right child
    }

    flatten(root->right);        
}
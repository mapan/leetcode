public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null) {
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;
            TreeNode rightmost=root.right;
            while(rightmost.right!=null)
                rightmost=rightmost.right;
            rightmost.right=temp;
        }
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

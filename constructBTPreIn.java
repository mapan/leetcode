public class Solution {
    HashMap<Integer,Integer> h;
    int i;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        h=new HashMap<Integer,Integer>();
        i=0;
        for(int j=0;j<inorder.length;j++)
            h.put(inorder[j],j);
        return build(0,preorder.length-1,preorder);
    }
    public TreeNode build(int l,int r,int[] pre) {
        if(l>r) return null;
        int mid=h.get(pre[i]);
        TreeNode root=new TreeNode(pre[i]);
        i++;
        root.left=build(l,mid-1,pre);
        root.right=build(mid+1,r,pre);
        return root;
    }
}

public class Solution {
    HashMap<Integer,Integer> h;
    int i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        h=new HashMap<Integer,Integer>();
        i=postorder.length-1;
        for(int j=0;j<inorder.length;j++)
            h.put(inorder[j],j);
        return build(0,postorder.length-1,postorder);
    }
    public TreeNode build(int l,int r,int[] post) {
        if(l>r) return null;
        int mid=h.get(post[i]);
        TreeNode root=new TreeNode(post[i]);
        i--;
        root.right=build(mid+1,r,post);
        root.left=build(l,mid-1,post);
        return root;
    }
}


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
    int preindex;
    HashMap<Integer,Integer> h;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        preindex=0;
        
        h=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++) 
            h.put(inorder[i],i);
        
        return build(preorder,inorder,0,preorder.length-1);
    }
    
    public TreeNode build(int[] preorder,int[] inorder,int start,int end) {
        if(start>end) return null;
        //if(start==end) {preindex++;return new TreeNode(inorder[start]);}
        TreeNode root=new TreeNode(preorder[preindex++]);
        //if(start==end) return root;
        int inindex=findInorder(inorder,root.val,start,end);
        root.left=build(preorder,inorder,start,inindex-1);
        root.right=build(preorder,inorder,inindex+1,end);
        return root;
    }
    public int findInorder(int[] inorder,int root,int start,int end) {
        /*for(int i=start;i<=end;i++) 
            if(inorder[i]==root)
                return i;
        return -1;*/
        return h.get(root);
    }
}


public class Solution {   
    int postindex;
    HashMap<Integer,Integer> h;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        postindex=postorder.length-1;
        
        h=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++) 
            h.put(inorder[i],i);
        
        return build(postorder,inorder,0,postorder.length-1);
    }
    
    public TreeNode build(int[] postorder,int[] inorder,int start,int end) {
        if(start>end) return null;
        //if(start==end) {preindex++;return new TreeNode(inorder[start]);}
        TreeNode root=new TreeNode(postorder[postindex--]);
        if(start==end) return root;
        int inindex=findInorder(inorder,root.val,start,end);
        root.right=build(postorder,inorder,inindex+1,end);        
        root.left=build(postorder,inorder,start,inindex-1);
        return root;
    }
    public int findInorder(int[] inorder,int root,int start,int end) {
        /*for(int i=start;i<=end;i++) 
            if(inorder[i]==root)
                return i;
        return -1;*/
        return h.get(root);
    }
}
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

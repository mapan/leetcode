/** 
 Changes the tree into its mirror image.

 So the tree... 
       4 
      / \ 
     2   5 
    / \ 
   1   3

 is changed to... 
       4 
      / \ 
     5   2 
        / \ 
       3   1

 Uses a recursive helper that recurs over the tree, 
 swapping the left/right pointers. 
*/ 
public void mirror() { 
  mirror(root); 
}

private void mirror(Node node) { 
  if (node != null) { 
    // do the sub-trees 
    mirror(node.left); 
    mirror(node.right);

    // swap the left/right pointers 
    Node temp = node.left; 
    node.left = node.right; 
    node.right = temp; 
  } 
} 

public Node mirror(Node root) { 
 if(root==null) return null;
 root.right=mirror(root.left);
 root.left=mirror(root.right);
 return root;
}


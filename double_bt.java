/** 
 Changes the tree by inserting a duplicate node 
 on each nodes's .left. 
  
 
 So the tree... 
    2 
   / \ 
  1   3

 Is changed to... 
       2 
      / \ 
     2   3 
    /   / 
   1   3 
  / 
 1

 Uses a recursive helper to recur over the tree 
 and insert the duplicates. 
*/ 
public void doubleTree() { 
 doubleTree(root); 
}

private void doubleTree(Node node) { 
  Node oldLeft;

  if (node == null) return;

  // do the subtrees 
  doubleTree(node.left); 
  doubleTree(node.right);

  // duplicate this node to its left 
  oldLeft = node.left; 
  node.left = new Node(node.data); 
  node.left.left = oldLeft; 
} 

public int size() { 
  return(size(root)); 
}
private int size(Node node) { 
  if (node == null) return(0); 
  else { 
    return(size(node.left) + 1 + size(node.right)); 
  } 
} 

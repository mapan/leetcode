public int size() { 
  return(size(root)); 
}
private int size(Node node) { 
  if (node == null) return(0); 
  else { 
    return(size(node.left) + 1 + size(node.right)); 
  } 
} 



  /** 
   Returns true if the given target is in the binary tree. 
   Uses a recursive helper. 
  */ 
  public boolean lookup(int data) { 
    return(lookup(root, data)); 
  } 
 

  /** 
   Recursive lookup  -- given a node, recur 
   down searching for the given data. 
  */ 
  private boolean lookup(Node node, int data) { 
    if (node==null) { 
      return(false); 
    }

    if (data==node.data) { 
      return(true); 
    } 
    else if (data<node.data) { 
      return(lookup(node.left, data)); 
    } 
    else { 
      return(lookup(node.right, data)); 
    } 
  } 
 

  /** 
   Inserts the given data into the binary tree. 
   Uses a recursive helper. 
  */ 
  public void insert(int data) { 
    root = insert(root, data); 
  } 
 

  /** 
   Recursive insert -- given a node pointer, recur down and 
   insert the given data into the tree. Returns the new 
   node pointer (the standard way to communicate 
   a changed pointer back to the caller). 
  */ 
  private Node insert(Node node, int data) { 
    if (node==null) { 
      node = new Node(data); 
    } 
    else { 
      if (data <= node.data) { 
        node.left = insert(node.left, data); 
      } 
      else { 
        node.right = insert(node.right, data); 
      } 
    }

    return(node); // in any case, return the new pointer to the caller 
  } 

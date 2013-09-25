/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        c(root);
    }
    public TreeLinkNode c(TreeLinkNode root) {
        if(root==null||(root.left==null&&root.right==null)) 
            return root;
        TreeLinkNode l=c(root.left);
        TreeLinkNode r=c(root.right);
        l.next=r;
        while(l.right!=null) {
            l.right.next=r.left;
            l=l.right;
            r=r.left;
        }
        return root;
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        Queue<TreeLinkNode> q=new LinkedList<TreeLinkNode>();
        q.add(root);
        int num=1;
        while(!q.isEmpty()) {
            int i=num;
            num=0;
            TreeLinkNode pre=null;
            while(i-->0) {
                TreeLinkNode n=q.remove();
                if(pre==null) pre=n;
                else {
                    pre.next=n;
                    pre=n;
                }
                if(n.left!=null) {
                    q.add(n.left);
                    num++;
                }
                if(n.right!=null) {
                    q.add(n.right);
                    num++;
                }
            }
        }
    }
}

void connect(TreeLinkNode *root) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    if (!root || (!root->left && !root->right))
        return;
    root->left->next = root->right;
    if (root->next) 
        root->right->next = root->next->left;

    connect(root->left);
    connect(root->right);
}


 public void connect(TreeLinkNode root) {  
   TreeLinkNode first = root;  
   while (first != null) {  
     TreeLinkNode cur = first;  
     // set up next pointers for the next level  
     while (cur != null) {  
       if (cur.left != null) cur.left.next = cur.right;  
       if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;  
       cur = cur.next;  
     }  
     // move to next level  
     first = first.left;  
   }  
 }
 
 
 // the link of level(i) is the queue of level(i+1)
void connect(TreeLinkNode * n) {
    while (n) {
        TreeLinkNode * next = NULL; // the first node of next level
        TreeLinkNode * prev = NULL; // previous node on the same level
        for (; n; n=n->next) {
            if (!next) next = n->left?n->left:n->right;

            if (n->left) {
                if (prev) prev->next = n->left;
                prev = n->left;
            }
            if (n->right) {
                if (prev) prev->next = n->right;
                prev = n->right;
            }
        }
        n = next; // turn to next level
    }
}


 void connect(TreeLinkNode *n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        while (n) {
        TreeLinkNode * next = NULL; // the first node of next level
        TreeLinkNode * prev = NULL; // previous node on the same level
        for (; n; n=n->next) {
            if (!next) next = n->left?n->left:n->right;

            if (n->left) {
                if (prev) prev->next = n->left;
                n->left->next=n->right;
                prev = n->right;
            }
        
        }
        n = next; // turn to next level
    }

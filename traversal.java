void pre(Node root) {
    while(root!=null) {
        print(root);
        if(root.left!=null)
            root=root.left;
        else if(root.right!=null)
            root=root.right;
        else {
            Node p=root.parent;
            while(p!=null&&(root==p.right||p.right==null)) {
                root=p;
                p=p.parent;
            }
            if(p==null) break;
            root=p.right;
        }
    }
}

void in(Node root) {
    while(root!=null) {
        while(root.left!=null)
            root=root.left;
        print(root);
        if(root.right!=null)
            root=root.right;
        else {
            Node p=root.parent;
            while(p!=null&&(root==p.right||p.right==null)) {
                if(p.right==null)
                    print(p);
                root=p;
                p=p.parent;
            }
            if(p==null) break;
            print(p);
            root=p.right;
        }
    }
}

void post(Node root) {
    while(root!=null) {
        if(root.left!=null) 
            root=root.left;
        else if(root.right!=null)
            root=root.right;
        else {
            print(root);
            Node p=root.parent;
            while(p!=null&&(root==p.right||p.right==null)) {
                print(p);
                root=p;
                p=p.parent;
            }
            if(p==null) break;
            root=p.right;
        }
    }
}

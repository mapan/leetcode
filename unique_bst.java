public class Num {
    static int[] num = null;
    public static int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null) num = new int[n+1]; 
        int numKeys=n;
        if (numKeys <=1) { 
    		return(1); 
  	} 
  	else if(num[n]!=0) return num[n];
  	else { 
	    // there will be one value at the root, with whatever remains 
	    // on the left and right each forming their own subtrees. 
	    // Iterate through all the values that could be the root... 
	    int sum = 0; 
	    int left, right, root;
	
	    for (root=1; root<=numKeys; root++) { 
	      left = numTrees(root-1); 
	      num[root-1]=left;
	      right = numTrees(numKeys - root);
	      num[numKeys-root]=right;
	
	      // number of possible trees with this root == left*right 
	      sum += left*right; 
	    }

    	return(sum); 
  	} 
    }


public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return g(1,n);
    }
    public ArrayList<TreeNode> g(int s,int e) {
        ArrayList<TreeNode> a=new ArrayList<TreeNode>();
        if(s>e) {
            a.add(null);
            return a;
        }
        for(int i=s;i<=e;i++) {
            //TreeNode root=new TreeNode(i);
            ArrayList<TreeNode> left=g(s,i-1);
            ArrayList<TreeNode> right=g(i+1,e);
            for(TreeNode l:left) {
                for(TreeNode r:right) {
                    TreeNode root=new TreeNode(i); 
                    // gotta create a new obj, otherwise will change the previous obj value
                    root.left=l;
                    root.right=r;
                    a.add(root);
                }
            }
        }
        return a;
    }
}

#########################################################################
    
public ArrayList<TreeNode> generateTrees(int n) {  
   return genSubTrees(1, n);  
 } 
private ArrayList<TreeNode> genSubTrees(int l, int r) {  
   ArrayList<TreeNode> trees = new ArrayList<TreeNode>();  
   if (l > r) { // return an empty tree 
     trees.add(null);  
   } else {  
     for (int i=l; i<=r; ++i) {  
       ArrayList<TreeNode> lefts = genSubTrees(l, i-1);  
       ArrayList<TreeNode> rights = genSubTrees(i+1, r);  
       for (TreeNode left : lefts) {  
         for (TreeNode right : rights) {  
           TreeNode root = new TreeNode(i);  
           root.left = left;  
           root.right = right;  
           trees.add(root);  
         }  
       }  
     }  
   }  
   return trees;  
 }  
    
   
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<ArrayList<TreeNode>>> t=new ArrayList<ArrayList<ArrayList<TreeNode>>>();
        for(int i=0;i<n+2;i++) {
            ArrayList<ArrayList<TreeNode>> a=new ArrayList<ArrayList<TreeNode>>();
            for(int j=0;j<n+2;j++) {
                ArrayList<TreeNode> b=new ArrayList<TreeNode>();
                a.add(b);
            }
            t.add(a);
        }
        dp(t,1,n);
        return t.get(1).get(n);
    }
    public void dp(ArrayList<ArrayList<ArrayList<TreeNode>>> t,int b,int e) {
        if(t.get(b).get(e).size()!=0) return;
        if(b>e) {
            t.get(b).get(e).add(null);
            return;
        }
        if(b==e) {
            TreeNode r=new TreeNode(b);
            t.get(b).get(e).add(r);
            return;
        }
        for(int i=b;i<=e;i++) {
            dp(t,b,i-1);
            dp(t,i+1,e);
            for(TreeNode l:t.get(b).get(i-1)) {
                for(TreeNode ri:t.get(i+1).get(e)) {
                    TreeNode r=new TreeNode(i);
                    r.left=l;
                    r.right=ri;
                    t.get(b).get(e).add(r);
                }
            }
        }
    }
}
    
   
class Solution {
public:
    vector<TreeNode *> generateTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<vector<TreeNode*>>> table(n+2, vector<vector<TreeNode*>>(n+2, vector<TreeNode*>(0,nullptr)));
        dp(table, 1, n);
        return table[1][n];
    }
private:
    void dp(vector<vector<vector<TreeNode*>>> &table, int begin, int end) {
        if (table[begin][end].size()!=0) return;

        if (begin>end) {
            table[begin][end] = vector<TreeNode*>(1,nullptr);
            return;
        }
        if (begin==end) {
            TreeNode * root = new TreeNode(begin);
            table[begin][end] = vector<TreeNode*>(1, root);
            return;
        }

        for (int i=begin; i<=end; ++i) {
            dp(table, begin, i-1);
            dp(table, i+1, end);
            for (auto iter_l=table[begin][i-1].begin(); iter_l!=table[begin][i-1].end(); ++iter_l) {
                for (auto iter_r=table[i+1][end].begin(); iter_r!=table[i+1][end].end(); ++iter_r) {
                    TreeNode *root = new TreeNode(i);
                    root->left = *iter_l;
                    root->right = *iter_r;
                    table[begin][end].push_back(root);
                }
            }
        }
    }
};
   
    
	public static void main(String[] args) {
		System.out.println(numTrees(3));
		String a = "helo";
		System.out.println(a.substring(0,0).equals("h"));
		System.out.println(a.substring(3,4));
		System.out.println(a.replace('j','i'));
		//System.out.println("1"&"0"); // can't apply to String
		System.out.println('1'&'0'); // 48
		String b="123";
		System.out.println(b.charAt(0)-'0');
	}
}

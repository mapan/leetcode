public class Num {
    static int[] num = null;
    public static int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num==null) num = new int[n+1]; int numKeys=n;
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
    
    
    /**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
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
        t.get(b).get(e).clear();
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

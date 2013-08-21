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

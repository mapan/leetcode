public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    // Start typing your Java solution below
    // DO NOT write main() function
    for(int i = triangle.size() - 2; i >= 0; i--)
    {
        for(int j = 0; j < triangle.get(i).size(); j++)
        {
            triangle.get(i).set(j, triangle.get(i).get(j) + 
				Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        }
    }
    return triangle.get(0).get(0);
}
bottom up just use N space with replace

 public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
            // Start typing your Java solution below
            // DO NOT write main() function
            int[] sum=new int[triangle.size()];
            
            for (int i=0;i<triangle.size();i++)
                sum[i]=triangle.get(triangle.size()-1).get(i);
            for (int i=triangle.size()-2;i>=0;i--){
                ArrayList<Integer> cur=triangle.get(i);
                for (int j=0;j<=i;j++)
                    sum[j]=cur.get(j)+Math.min(sum[j], sum[j+1]);
            }

            return sum[0];
            
}


public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle.size()==0) return 0;
        return dfs(triangle,1,triangle.get(0).get(0),0);
    }
    public int dfs(ArrayList<ArrayList<Integer>> t,int l,int sum,int i) {
        if(l==t.size()) return sum;
        int left=dfs(t,l+1,sum+t.get(l).get(i),i);
        int right=dfs(t,l+1,sum+t.get(l).get(i+1),i+1);
        return left<right?left:right;
    }
  

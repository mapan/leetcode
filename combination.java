public class Solution {
    ArrayList<ArrayList<Integer>> r;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sofar=new ArrayList<Integer>();
        c(n,1,k,sofar);
        return r;
    }
    public void c(int n,int start,int k,ArrayList<Integer> sofar) {
        if(k==0) {
            ArrayList<Integer> cp=new ArrayList<Integer>(sofar);
            r.add(cp);
            return;
        }
        for(int i=start;i<=n;i++) {
            sofar.add(i);
            c(n,i+1,k-1,sofar);
            sofar.remove(sofar.size()-1);
        }
    }
}

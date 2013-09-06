public class Solution {
    ArrayList<ArrayList<Integer>> r;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sofar=new ArrayList<Integer>();
        Arrays.sort(candidates);
        c(candidates,target,sofar,0);
        return r;
    }
    public void c(int[] cand,int target,ArrayList<Integer> sofar,int pre) {
        if(target==0) {
            ArrayList<Integer> cp=new ArrayList<Integer>(sofar);
            r.add(cp);
            return;
        }
        if(target<cand[0]) return; // save time
        for(int i=0;i<cand.length;i++) {
            if(cand[i]<pre) continue;
            sofar.add(cand[i]);
            c(cand,target-cand[i],sofar,cand[i]);
            sofar.remove(sofar.size()-1);
        }
    }
}

public class Solution {
    ArrayList<ArrayList<Integer>> r;
    ArrayList<Integer> d;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        d=new ArrayList<Integer>();
        ArrayList<Integer> sofar=new ArrayList<Integer>();
        Arrays.sort(candidates);
        c(candidates,target,sofar,0);
        return r;
    }
    public void c(int[] cand,int target,ArrayList<Integer> sofar,int ind) {
        if(target==0) {
            ArrayList<Integer> cp=new ArrayList<Integer>(sofar);
            r.add(cp);
            return;
        }
        if(target<cand[0]) return;
        for(int i=ind;i<cand.length;i++) {
            if (i>ind && cand[i] == cand[i-1]) continue;
            sofar.add(cand[i]);
            d.add(cand[i]);
            c(cand,target-cand[i],sofar,i+1);
            sofar.remove(sofar.size()-1);
            //d.remove(cand[i]);
            //d.remove((Integer)cand[i]);
            d.remove(d.size()-1);
        }
    }
}




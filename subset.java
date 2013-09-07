public class Solution {
    ArrayList<ArrayList<Integer>> r;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sofar=new ArrayList<Integer>();
        Arrays.sort(S);
        s(S,0,sofar);
        return r;
    }
    public void s(int[] S,int ind,ArrayList<Integer> sofar) {
        if(ind==S.length) {
            ArrayList<Integer> cp=new ArrayList<Integer>(sofar);
            r.add(cp);
            return;
        }
        //if(ind>0&&S[ind]==S[ind-1]) 
            //s(S,ind+1,sofar);
        //else {
            sofar.add(S[ind]);
            s(S,ind+1,sofar);
            sofar.remove(sofar.size()-1);
            s(S,ind+1,sofar);
        //}
    }
}

public class Solution {
    ArrayList<ArrayList<Integer>> r;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sofar=new ArrayList<Integer>();
        Arrays.sort(num);
        s(num,0,sofar);
        return r;
    }
    public void s(int[] S,int ind,ArrayList<Integer> sofar) {
        if(ind==S.length) {
            ArrayList<Integer> cp=new ArrayList<Integer>(sofar);
            r.add(cp);
            return;
        }
        if(sofar.contains(S[ind])) {
            sofar.add(S[ind]);
            s(S,ind+1,sofar);
            sofar.remove(sofar.size()-1); // still need remove previous one!!!!
        }
        else {
            sofar.add(S[ind]);
            s(S,ind+1,sofar);
            sofar.remove(sofar.size()-1);
            s(S,ind+1,sofar);
        }
    }
}

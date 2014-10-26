public class Solution {
    ArrayList<ArrayList<Integer>> r;
    HashMap<Integer,Boolean> h; // gotta be uppercase
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<Integer>>();
        h=new HashMap<Integer,Boolean>();
        ArrayList<Integer> sofar=new ArrayList<Integer>();
        p(sofar,num,0);
        return r;
    }
    public void p(ArrayList<Integer> sofar,int[] num,int ind) {
        if(ind==num.length) {
            ArrayList<Integer> c=new ArrayList<Integer>(sofar);
            r.add(c);
            return;
        }
        for(int i=0;i<num.length;i++) {
        
            boolean f=false;
            for(int j=i-1;j>=0;j--) {
                if(h.get(j)) continue;
                if(num[j]==num[i]){
                    f=true; break;
                }
            }
            if(f) continue;                         // could use arraylist to check previous used indexes
          
            if(h.containsKey(i)&&h.get(i)) continue;
            if (hh.contains(num[i])) continue;
            hh.add(num[i]);
            h.put(i,true);
            sofar.add(num[i]);
            p(sofar,num,ind+1);
            sofar.remove(sofar.size()-1);
            h.put(i,false);
        }
    }
}


public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        for(i=num.length-1;i>=1;i--) {
            if(num[i]>num[i-1]) {
                Arrays.sort(num,i,num.length);
                for(int j=i;j<num.length;j++) {
                    if(num[j]>num[i-1]) {
                        int temp=num[i-1];
                        num[i-1]=num[j];
                        num[j]=temp;
                        break;
                    }
                }
                break;
            }
        }
        if(i==0) Arrays.sort(num);
    }
}

http://n00tc0d3r.blogspot.com/2013/05/permutation-sequence.html

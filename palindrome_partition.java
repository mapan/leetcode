public class Solution {
    ArrayList<ArrayList<String>> r;
    HashMap<String,Boolean> h;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<ArrayList<String>>();
        h=new HashMap<String,Boolean>();
        p(new ArrayList<String>(),s);
        return r;
    }
    public void p(ArrayList<String> sofar,String s) {
        if(s.length()==0) {
            ArrayList<String> cp=new ArrayList<String>(sofar);
            r.add(cp);
            return;
        }
        for(int i=1;i<=s.length();i++) {
            // i should <= to contain whole string
            String a=s.substring(0,i);
            if((h.containsKey(a)&&h.get(a))||ispal(a)) {
                h.put(a,true);
                sofar.add(a);
                p(sofar,s.substring(i));
                sofar.remove(sofar.size()-1);
            }
            else h.put(a,false);
        }
    }
    public boolean ispal(String s) {
        if(s.length()<=1) return true;
        int l=0,r=s.length()-1;
        while(l<r) {
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}


public class Solution {
    HashMap<String,Boolean> h;
    int min;
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        h=new HashMap<String,Boolean>();
        if(s.length()==0) return 0;
        min=s.length()-1;
        p(0,s);
        return min;
    }
    public void p(int cuts,String s) {
        if(cuts-1>=min) return;
        if(s.length()==0) {
            min=Math.min(min,cuts-1);
            return;
        }
        for(int i=1;i<=s.length();i++) {
            // i should <= to contain whole string
            String a=s.substring(0,i);
            if((h.containsKey(a)&&h.get(a))||ispal(a)) {
                h.put(a,true);
                p(cuts+1,s.substring(i));
            }
            else h.put(a,false);
        }
    }
    public boolean ispal(String s) {
        if(s.length()<=1) return true;
        int l=0,r=s.length()-1;
        while(l<r) {
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}


Using DP to calculate and save if a given substring of s is palindrome. Then using backtracking to build up the solution.

public ArrayList<ArrayList<String>> partition(String s) {
    if(s == null || s.length() == 0)
        return new ArrayList<ArrayList<String>>();
    boolean[][] isPa = new boolean[s.length()][s.length()];
    for(int i = 0; i < s.length(); i++){
        isPa[i][i] = true;
    }
    for(int i = s.length() - 2; i >= 0; i --){
        isPa[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        for(int j = i + 2; j < s.length(); j++) 
            isPa[i][j] = (s.charAt(i) == s.charAt(j)) && isPa[i + 1][j - 1];
    }
    return partitionHelper(s, 0, isPa);
}

public ArrayList<ArrayList<String>> partitionHelper(String s, int start, boolean[][] isPa){
    ArrayList<ArrayList<String>> pa = new ArrayList<ArrayList<String>>();
    if(start == s.length()){
        pa.add(new ArrayList<String>());
        return pa;
    }
    for(int i = start; i < s.length(); i++){
        if(isPa[start][i])
            for(ArrayList<String> subPa: partitionHelper(s, i + 1, isPa)){
                subPa.add(0, s.substring(start, i + 1));
                pa.add(subPa);
            }
    }
    return pa;
}


http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
http://www.geeksforgeeks.org/dynamic-programming-set-1/
https://sites.google.com/site/sarvasite/algorithms/trees/tree-traversal#TOC-Inorder-traversal
http://n00tc0d3r.blogspot.com/2013/07/word-ladder-ii.html

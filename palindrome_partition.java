public class Solution {
    ArrayList<ArrayList<String>> all=new ArrayList<ArrayList<String>>();
    
    boolean isPalin(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }    
        return true;
    }
    
    void dfs(String s, int start, ArrayList<String> al){
        if(start==s.length()){
            all.add(new ArrayList<String>(al));
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            if(isPalin(s,start,i-1)){
                al.add(s.substring(start,i));
                dfs(s,i,al);
                al.remove(al.size()-1);
            }
        }    
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
        all.clear();
        ArrayList<String> al=new ArrayList<String>();
        dfs(s,0,al);
        return all;
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

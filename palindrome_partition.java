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

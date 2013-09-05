public class Solution {
    ArrayList<Character> left;
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        left=new ArrayList<Character>();
        return valid(s);
    }
    public boolean valid(String s) {
        if(s.equals("")) 
            if(left.isEmpty()) return true;
            else return false;
        char c=s.charAt(0);
        if(c=='('||c=='{'||c=='[')
            left.add(c);
        else {
            char l='[';
            if(c==')') l='(';
            else if(c=='}') l='{';
            if(!left.contains(l)) return false;  if(left.size()==0) return false;
            if(left.get(left.size()-1)!=l) return false;
            // the last element of the list must match current one
            // use Stackk!
            left.remove(left.size()-1); // remove(object) the first appearance
        }
        return valid(s.substring(1));
    }
}

http://n00tc0d3r.blogspot.com/2013/04/longest-valid-parentheses.html

public class Solution {
    ArrayList<String> r;
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        r=new ArrayList<String>();
        g("",n,n);
        return r;
    }
    public void g(String sofar,int left,int right) {
        if(left==0&&right==0) {
            String cp=new String(sofar);
            r.add(cp);
            return;
        }
        if(left>0) g(sofar+"(",left-1,right);
        if(left<right) g(sofar+")",left,right-1);
    }
}

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

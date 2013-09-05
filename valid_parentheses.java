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
            if(!left.contains(l)) return false;
            if(left.get(left.size()-1)!=l) return false;
            left.remove(left.size()-1); // remove(object) the first appearance
        }
        return valid(s.substring(1));
    }
}

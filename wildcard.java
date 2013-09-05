public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.equals("")) {
            if(p.equals("")||p.equals("*"))
                return true;
            return false;
        }
        if(p.equals("")) 
            return false;
        
        String ss="",pp="";
        int j=0;
        while(p.charAt(j)=='*') j++;
        if(p.charAt(0)=='*') {
            int i;
            for(i=0;i<=s.length();i++) {
                if(isMatch(s.substring(i),p.substring(j))) return true;
            }
            return false;
        }
        else {
            if(p.charAt(0)!='?')
                if(s.charAt(0)!=p.charAt(0))
                    return false;
            ss=s.substring(1);
            pp=p.substring(1);
        }
        
        return isMatch(ss,pp);
    }
}

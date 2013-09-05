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
        if(p.charAt(0)=='*') {
            int i;
            for(i=0;i<s.length();i++ {
                if(i>=2) 
                    if(s.charAt(i-1)!=s.charAt(i-2))
                        break;
                if(isMatch(s.substring(i),p.substring(1))) return true;
            }
            ss=s.substring(i-1);
            pp=p.substring(1);
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

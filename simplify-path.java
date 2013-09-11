public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=path.length();
        if(len<2) return path;
        StringBuilder s=new StringBuilder();
        s.append('/');
        for(int i=1;i<len;i++) {
            char c=path.charAt(i);
            if(c=='/') {
                if(s.charAt(s.length()-1)=='/'||i==len-1) continue;
                else s.append(c);
            }
            else if(c=='.') {
                if(i==len-1||path.charAt(i+1)!='.') {
                    if(i!=len-1&&path.charAt(i+1)!='/')
                        s.append(c);
                    continue;
                }
                else { // ..
                    // /..
                    if(s.length()==1) {
                        i++;
                        continue;
                    }
                    s.deleteCharAt(s.length()-1);
                    //  /../
                    int j=s.lastIndexOf("/");
                    s.delete(j+1,s.length());
                    i++;
                }
            }
            else s.append(c);
        }
        if(s.length()>1&&s.charAt(s.length()-1)=='/')
            s.deleteCharAt(s.length()-1);
        return s.toString();
    }
}

public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(path.length()<=1) return path;
        char[] p=path.toCharArray();
        int current=0,start=0,end=1;
        while(end<p.length) {
            while(end<p.length&&p[end]!='/') end++; //p[end++]!='/'
            if(end-start==3&&p[end-1]=='.'&&p[end-2]=='.') {
                //if(current>0) {
                //if(current>0) current--;
                while(current>0&&p[--current]!='/');//current--;
                start=end;
                //}
            }
            else if(end-start==1||(end-start==2&&p[end-1]=='.')) {
                start=end;
                //end++;
            }
            else {
                while(start<end) p[current++]=p[start++];
            }
            end++;
        }
        return new String(p,0,current==0?1:current);
    }
}

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

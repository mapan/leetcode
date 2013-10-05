public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1) return "1";
        String pre="1",r="";
        while(n>1) {
            r="";
            for(int i=0;i<pre.length();) {
                int j=i+1,c=1;
                while(j<pre.length()&&pre.charAt(j)==pre.charAt(j-1)) {
                    c++; j++;
                }
                i=j;
                r+=c+""+pre.charAt(j-1);
            }
            pre=r;
            n--;
        }
        return r;
    }
}

public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1) return "1";
        String pre="1",r="";
        while(n>1) {
            r="";
            for(int i=0;i<pre.length();) {
                int j=i,c=1;
                while(j<pre.length()-1&&pre.charAt(j)==pre.charAt(j+1)) {
                    c++; j++;
                }
                i=j+1;
                r+=c+pre.substring(j,j+1);
            }
            pre=r;
            n--;
        }
        return r;
    }
}

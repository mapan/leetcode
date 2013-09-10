public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==1) return "1";
        if(n==2) return "11";
        String pre="11",r="";
        while(n>2) {
            r="";
            for(int i=1;i<pre.length();) {
                int j=i+1,c=1;
                while(j<pre.length()&&pre.charAt(j)==pre.charAt(j-1)) {
                    c++; j++;
                }
                i=j;
                r+=c+pre.substring(j-1,j);
            }
            pre=r;
            n--;
        }
        return r;
    }
}

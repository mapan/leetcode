public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack.length()==0||needle.length()==0) {
            if(haystack.length()==0) return null;
            if(needle.length()==0) return haystack;
            return "";
        }
        for(int i=0;i<=haystack.length()-needle.length();i++) {
            if(haystack.charAt(i)==needle.charAt(0)) {
                int j=1;
                while(j<needle.length()&&haystack.charAt(i+j)==needle.charAt(j))
                    j++;
                if(j==needle.length()) return haystack.substring(i);
            }
        }
        return null;
    }
}

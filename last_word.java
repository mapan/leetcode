public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=s.length()-1,c=0;
        while(i>=0&&s.charAt(i)==' ') i--;
        while(i>=0&&s.charAt(i)!=' ') {c++;i--;}
        return c;
    }
}


public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int c=0,len=s.length(),i=len-1;
        if(len==0) return c;
        while(i>=0) {
            if(c!=0&&s.charAt(i)==' ') break;
            else if(s.charAt(i)!=' ') c++;
            i--;
        }
        return c;
    }
}

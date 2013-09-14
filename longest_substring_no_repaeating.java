public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=s.length(),len=0,r=0;
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<l;) {
            char c=s.charAt(i);
            if(h.containsKey(c)) {
                i=h.get(c)+1;  // we should restart and clear the hash map before the repeated c
                h.clear();
                len=0;
            }
            else {
                h.put(c,i);
                len++;
                r=Math.max(len,r);
                i++;
            }
        }
        return r;
    }
}


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()<=1) return s.length();
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int curmax=0,max=0;
        for(int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if(h.containsKey(c)) {     
                if(i-h.get(c)<curmax) {  // previous is in the middle of curmax, then restart from the previous next char
                    curmax=1;           // otherwise previous is the start of curmax, then simply replace current with previous
                    i=h.get(c)+1;     
                    c=s.charAt(i);
                    h.clear();
                }
            }
            else {
                curmax++;
            }
            h.put(c,i);
            max=curmax>max?curmax:max;
        }
        return max;
    }
}
If we hit a recurrence of a character, it means that we find a substring without repeating characters (ended before this character). 
Suppose we start from s[i] and find out the s[j] is same as s[k], where k<j. That said, s[i..j-1] is a substring without repeats. 
That also tells us that there is no repeating characters between k+1 and j.
http://n00tc0d3r.blogspot.com/2013/04/longest-substring-without-repeating.html

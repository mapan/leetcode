public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.isEmpty()) return true;
        int l=0,r=s.length()-1;
        s=s.toLowerCase();
        while(l<r) {
            if(s.charAt(l)==s.charAt(r)) {
                //if(valid(s.charAt(l)) {
                    l++; r--;
                //}
            }
            else {
                if(valid(s.charAt(l))&&valid(s.charAt(r))) return false;
                if(!valid(s.charAt(l))) l++;
                if(!valid(s.charAt(r))) r--;
            }
        }
        return true;
    }
    public boolean valid(char c) {
        if((c<'a'||c>'z')&&(c<'0'||c>'9')) return false;
        if(!((c>='a'&&c<='z')||(c>='0'&&c<='9')))
        return true;
    }
}

 /* Remove non-alphanumeric char and change to lowercase  
  * ss = normalize(s) is equivalent to  
  *  ss = s.toLowerCase().replaceAll("[^a-z0-9]", "");  
  */  
 private String normalize(String s) {  
   StringBuilder ss = new StringBuilder();  
   for (int i=0; i<s.length(); ++i) {  
     char c = s.charAt(i);  
     // skip non-alphanumeric  
     if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9'))  
       continue;  
     // lowercase  
     if (c >= 'A' && c <= 'Z') c = (char)(c - ('A' - 'a'));  
     ss.append(c);  
   }  
   return ss.toString();  
 }  
   
 public boolean isPalindrome(String s) {  
   String ss = normalize(s);  
   int left=0, right=ss.length()-1;  
   while (left < right) {  
     if (ss.charAt(left++) != ss.charAt(right--)) return false;  
   }  
   return true;  
 }

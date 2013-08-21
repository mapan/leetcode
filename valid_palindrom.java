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

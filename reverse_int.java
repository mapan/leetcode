public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Integer> s=new LinkedList<Integer>();
        // already handle - boolean n=x<0?true:false;
        while(x!=0) {
            s.add(x%10);
            x/=10;
        }
        while(!s.isEmpty()) {
            x*=10;
            x+=s.remove();
        }
        return x;
    }
}

 public int reverse(int x) {  
   long res = 0;  
   
   while (x != 0) {  
     res = (res * 10) + x % 10;  
     x /= 10;  
   }  
   
   return (int)res;  
 } 
 

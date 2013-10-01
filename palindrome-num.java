public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return false;
        if(x<10) return true;
        //int divd=10; overflow
        long divd=10;
        while(divd<=x) divd*=10;
        divd/=10;
        while(divd>1) {
            //int h=x/divd;
            //int t=x%10;
            if(x/divd!=x%10) return false;
            x=(int)(x%divd)/10;
            divd/=100;
        }
        return true;
    }
}

bool isPalindrome(int x) {
  if (x < 0) return false;
  int div = 1;
  while (x / div >= 10) {
    div *= 10;
  }        
  while (x != 0) {
    int l = x / div;
    int r = x % 10;
    if (l != r) return false;
    x = (x % div) / 10;
    div /= 100;
  }
  return true;
}

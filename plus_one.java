public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry=0;
        for(int i=digits.length-1;i>=0;i--) {
            int s=digits[i]+carry+(i==digits.length-1?1:0);
            carry=s>=10?1:0;
            digits[i]=s%10;
            if(carry==0) break;
        }
        if(carry==1) {
            int[] r=new int[digits.length+1];
            r[0]=1;
            for(int i=0;i<digits.length;i++)
                r[i+1]=digits[i];
            return r;
        }
        return digits;
    }
}

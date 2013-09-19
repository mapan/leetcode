public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0,j=str.length()-1;
        long result=0;
        boolean neg=false;
        while(i<=j&&(str.charAt(i)<'0'||str.charAt(i)>'9')&&str.charAt(i)!='-'&&str.charAt(i)!='+') i++;
        if(i<=j&&str.charAt(i)=='-') {neg=true;i++;}
        if(i<=j&&str.charAt(i)=='+') i++;
        while(j>=0&&(str.charAt(j)<'0'||str.charAt(j)>'9')) j--;
        if(i>j) return 0;
        for(;i<=j;i++) {
            char c=str.charAt(i);
            if(c<'0'||c>'9') break;
            result=result*10+(str.charAt(i)-'0');
            if(!neg&&result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(neg&&(0-result)<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if(neg) return (int)(0-result);
        return (int)result;
    }
}

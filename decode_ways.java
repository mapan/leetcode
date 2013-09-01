public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=s.length();
        if(len==0) return len;
        if(Integer.parseInt(s.substring(0,1))==0)
            return 0;
        int[] way=new int[len];
        way[0]=1;
        for(int i=1;i<len;i++) {
            if(valid(s.substring(i,i+1)))
                way[i]=way[i-1];
            if(valid(s.substring(i-1,i+1)))
                way[i]+=(i==1?1:way[i-2]);
        }
        return way[len-1];
    }
    public boolean valid(String s) {
        if(Integer.parseInt(s.substring(0,1))==0)
            return false;
        if(Integer.parseInt(s)>0&&Integer.parseInt(s)<=26)
            return true;
        return false;
    }
}

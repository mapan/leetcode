public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max=0,ii;
        if(height.length==0) return 0;
        for( ii=0;ii<height.length;ii++) 
            if(height[ii]!=height[0]) break;
        if(ii==height.length) return height.length*height[0];
        
        for(int i=0;i<height.length;i++) {
            int c=(1+left(i-1,height[i],height)+right(i+1,height[i],height))*height[i];
            max=Math.max(max,c);
        }
        return max;
    }
    public int left(int i,int h,int[] height) {
        int l=0;
        for(;i>=0;i--)
            if(height[i]>=h) l++;
            else break;
        return l;
    }
    public int right(int i,int h,int[] height) {
        int l=0;
        for(;i<height.length;i++)
            if(height[i]>=h) l++;
            else break;
        return l;
    }
}

public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=0,r=A.length-1;
        while(l<r) {
            int mid=l+(r-l)/2;
            if(A[mid]>target) r=mid-1;
            else if(A[mid]<target) l=mid+1;
            else return mid;
        }
        if(target>A[l]) return l+1;
        return l;
    }
}

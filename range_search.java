public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l=0,r=A.length-1;
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(A[mid]>target) r=mid-1;
            else if(A[mid]<target) l=mid+1;
            else {
                int s=bs(A,l,mid-1,target-0.1);
                int e=bs(A,mid+1,r,target+0.1);
                return new int[]{s,e-1};
            }
        }
        return new int[]{-1,-1};
    }
    public int bs(int[] A,int l,int r,double target) {
        while(l<=r) {
            int mid=l+(r-l)/2;
            if(A[mid]>target) r=mid-1;
            else if(A[mid]<target) l=mid+1;
            //else return mid;
        }
        return l;
    }
}

class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        vector<int> range(2, -1);
        int lower = 0;
        int upper = n;
        int mid;

        // Search for lower bound
        while (lower < upper) {
            mid = (lower + upper) / 2;
            if (A[mid] < target)
                lower = mid + 1;
            else
                upper = mid;
        }

        // If the target is not found, return (-1, -1)
        if (A[lower] != target)
            return range;
        range[0] = lower;

        // Search for upper bound
        upper = n;
        while (lower < upper) {
            mid = (lower + upper) / 2;
            if (A[mid] > target)
                upper = mid;
            else
                lower = mid + 1;
        }
        range[1] = upper - 1;

        return range;
    }
};

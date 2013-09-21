public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum_end_here=0,max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++) {
            sum_end_here+=A[i];
            max=Math.max(max,sum_end_here);
            if(sum_end_here<0) sum_end_here=0;
        }
        return max;
    }
}

int maxSubArray(int A[], int n) {
    return maxSub(A,0,n-1);
}
int maxSub(int A[], int left, int right){
    if(left>right)return INT_MIN;
    if(left==right)return A[left];
    int mid=left+((right-left)>>1);
    int leftMax=INT_MIN, rightMax=INT_MIN;
    for(int i=mid-1, currSum=0; i>=left; --i)
        currSum+=A[i], leftMax=max(leftMax, currSum);
    for(int i=mid+1, currSum=0; i<=right; ++i)
        currSum+=A[i], rightMax=max(rightMax, currSum);
    int midMax=A[mid]+max(leftMax,0)+max(rightMax,0);
    return max(max(maxSub(A,left,mid-1),maxSub(A,mid+1,right)),midMax);
}

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //if(m==0||n==0) return;
        int i=m+n-1;
        n--;m--;
        while(m>=0&&n>=0) {
            if(A[m]>B[n]) A[i--]=A[m--];
            else A[i--]=B[n--];
        }
        while(n>=0) A[i--]=B[n--];
    }
}
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0||m==0) {
            if(n!=0) {
                for(int i=n;i>0;i--)
                    A[i-1]=B[i-1];
            }
            return;
        }
        if(A[m-1]<B[n-1]) {
            A[m+n-1]=B[n-1];
            merge(A,m,B,n-1);
        }
        else {
            A[m+n-1]=A[m-1];
            merge(A,m-1,B,n);
        }
    }
}

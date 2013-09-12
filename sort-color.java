public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int c1=0,c2=0;
        for(int i=0;i<A.length;i++) {
            int val=A[i];
            if(val==0) {
                if(c1+c2!=0) {
                    int temp=A[i-(c1+c2)];
                    A[i-(c1+c2)]=val;
                    A[i]=temp;
                    if(temp==1) {i--;c1--;}
                }
            }
            else if(val==1) {
                if(c2!=0) {
                    int temp=A[i-c2];
                    A[i-c2]=val;
                    A[i]=temp;
                }
                c1++;
            }
            else c2++;
        }
    }
}

public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0||A.length==1) return true;
        if(A[0]==0) return false;
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()) {
            int i=q.remove();
            int end=A[i];
            for(int j=1;j<=end;j++) {
                int index=i+j;
                if(index==A.length-1) 
                    return true;
                q.add(index);
            }
        }
        return false;
    }
}

public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<=1) return true;
        if(A[0]==0) return false;
        boolean[] b=new boolean[A.length-1];
        boolean flag=false;
        for(int i=A.length-2;i>=0;i--) {
            for(int j=1;j<=A[i];j++) {
                if(!flag) {
                    if(A[i]+i>=A.length-1) 
                        b[i]=flag=true;
                    break;
                }
                if(j+i==A.length-1||b[j+i]) {
                    b[i]=true;
                    flag=true;
                    break;
                }
            }
        }
        return b[0];
    }
}

 public boolean canJump(int[] A) {  
   int next = A.length - 1;  
   for (int i=A.length-2; i>=0; --i) {   
     if (A[i] >= (next - i)) {   
       next = i;   
     }  
   }   
   return (next == 0);  
 } 
 
 
 public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int des=A.length-1;
        int[] j=new int[A.length];
        for(int i=A.length-2;i>=0;i--) {
            if(i+A[i]>=des) j[i]=1;
            else {
                int min=Integer.MAX_VALUE;
                for(int m=1;m<=A[i];m++)
                    min=Math.min(min,j[i+m]);
                j[i]=(min==Integer.MAX_VALUE)?min:min+1;
            }
        }
        return j[0];
    }
}
 
 
 public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<=1) return 0;
        int[] count=new int[A.length-1];
        count[A.length-2]=1;
        for(int i=A.length-3;i>=0;i--) {
            int min=A.length-1;//Integer.MAX_VALUE;
            for(int j=A[i];j>=1;j--) {
                if(i+j>=A.length-1) {
                    min=1;
                    break;
                }
                else {
                    min=(count[i+j]+1<min)?(count[i+j]+1):min;
                    if(min==2) break;
                }
            }
            count[i]=min;
        }
        return count[0];
    }
}
http://n00tc0d3r.blogspot.com/2013/03/jump-game.html

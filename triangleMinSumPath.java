public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len=triangle.size();
        ArrayList<Integer> last=triangle.get(len-1);
        for(int i=len-2;i>=0;i--) {
            for(int j=0;j<i+1;j++) {
                last.set(j,triangle.get(i).get(j)+Math.min(last.get(j),last.get(j+1)));
            }
        }
        return last.get(0);
    }
}

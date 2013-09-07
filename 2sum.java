public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++)
            h.put(numbers[i],i);
        for(int i=0;i<numbers.length;i++) {
            int j=target-numbers[i];
            if(h.containsKey(j))
                return new int[]{Math.min(i+1,h.get(j)+1),Math.max(i+1,h.get(j)+1)};
        }
        return null;
    }
}

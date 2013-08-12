import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> tripletSet = new HashSet();
 
        int numSize = num.length;
        if (numSize < 3) return result;
        for (int i = 0; i < numSize - 2; i++) {
            int first = i + 1;
            int last = numSize - 1;
            int target = 0 - num[i];        
            while (first < last) {
                int sumTwo = num[first] + num[last];
                if (sumTwo < target) first++;
                else if (sumTwo > target) last--;
                else {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(num[i]);
                    triplet.add(num[first]);
                    triplet.add(num[last]);
                    // Avoid duplicates
                    if (tripletSet.add(triplet)) result.add(triplet);
                    first++;
                    last--;      
                }
            }       
        }
        return result;          
    }
}
 
// Don't use set to avoid duplicate.
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //HashSet tripletSet = new HashSet();
 
        int numSize = num.length;
        if (numSize < 3) return result;
        for (int i = 0; i < numSize - 2; ) {
            int first = i + 1;
            int last = numSize - 1;
            int target = 0 - num[i];        
            while (first < last) {
                int sumTwo = num[first] + num[last];
                if (sumTwo < target) first++;
                else if (sumTwo > target) last--;
                else {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(num[i]);
                    triplet.add(num[first]);
                    triplet.add(num[last]);
                    result.add(triplet);
                    // Avoid duplicates
                    while (first + 1 < last && num[first] == num[first + 1]) {
                        // go to num[first + 1]
                        first++;
                    }
                    // skip last duplicate
                    first++;
                    while (last - 1 > first && num[last] == num[last - 1]) {
                        last--;
                    }
                    last--;                    
                }
            }
            //Avoid duplicates
            while (i + 1 < numSize && num[i + 1] == num[i]) {
                i++;
            }
            i++;
        }
        return result;          
    }
}
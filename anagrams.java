import java.util.*; 
public class Solution {
    
    public String bucketSort(String s) {
        int[] bucket = new int[26];
        for(int i = 0;i < s.length();i++) {
            bucket[s.charAt(i)-'a']++;
        }
        String result = "";
        for(int i = 0;i < 26;i++) {
            for(int j = 0;j < bucket[i];j++) {
                result += (char)('a'+i);
            }
        }
        return result;
    }
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>>  h = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0;i < strs.length;i++) {
            String sorted = bucketSort(strs[i]);
            if(!h.containsKey(sorted)) 
                h.put(sorted,new ArrayList<Integer>());
            h.get(sorted).add(i);
        }
        Iterator i = h.values().iterator();
        ArrayList<Integer> a;
        while(i.hasNext()) {
            a = (ArrayList<Integer>)i.next();
            if(a.size() > 1) 
                for(int i2 = 0;i2 < a.size();i2++)
                    result.add(strs[a.get(i2)]);
        }
        return result;
    }
}

String original = "edcAaB";
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
        
public class AnagramComparator implements Comparator<String> {
    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
Arrays.sort(array,new AnagramComparator())
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> r=new ArrayList<String>();
        HashMap<String,ArrayList<Integer>> h=new HashMap<String,ArrayList<Integer>>();
        for(int i=0;i<strs.length;i++) {
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            String s=new String(c);
            if(!h.containsKey(s)) {
                h.put(s,new ArrayList<Integer>());
            }
            h.get(s).add(i);
        }
        for(ArrayList<Integer> a:h.values()) {
            if(a.size()>1) {
                for(int i:a)
                    r.add(strs[i]);
            }
        }
        return r;
    }
}


public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> r=new ArrayList<String>();
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        HashSet<String> h2=new HashSet<String>();
        for(int i=0;i<strs.length;i++) {
            char[] c=strs[i].toCharArray();
            Arrays.sort(c);
            String s=new String(c);
            if(h.containsKey(s)) {
                r.add(strs[i]);
                String a=strs[h.get(s)];
                if(!h2.contains(a)) {
                    r.add(a);
                    h2.add(a);
                }
            }
            else h.put(s,i);
        }
        return r;
    }
}


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
